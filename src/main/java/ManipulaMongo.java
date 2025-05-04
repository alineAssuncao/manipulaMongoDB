import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.mongodb.client.*;
import org.bson.Document;

@Component
public class ManipulaMongo {

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Value("${spring.data.mongodb.database}")
    private String dataBase;

    @Value("${spring.data.mongodb.collection}")
    private String collection;

    public ManipulaMongo() {}

    // Conectar ao MongoDB (sem @Autowired)
    public MongoClient conectarMongo() {
        try {
            System.out.println("Conectando com: " + uri);
            System.out.println("Database e Collection: "+dataBase + collection);
            MongoClient mongoClient = MongoClients.create(uri);
            System.out.println("Conexão com MongoDB estabelecida com sucesso!");
            return mongoClient;
        } catch (Exception e) {
            System.err.println("Erro ao conectar com MongoDB.");
            e.printStackTrace();
            return null;
        }
    }

    // Função para realizar uma consulta
    public void consultaMongo(Document filtro) {
        try (MongoClient mongoClient = conectarMongo()) {
            if (mongoClient == null) {
                System.err.println("Não foi possível conectar ao MongoDB.");
                return;
            }

            // Selecionando o database e a collection
            MongoDatabase db = mongoClient.getDatabase(dataBase);
            MongoCollection<Document> clt = db.getCollection(collection);

            // Consultando os documentos com filtro
            FindIterable<Document> resultados = clt.find(filtro);

            // Exibindo os resultados
            for (Document doc : resultados) {
                System.out.println(doc.toJson());
            }
        } catch (Exception e) {
            System.err.println("Erro ao realizar a consulta.");
            e.printStackTrace();
        }
    }
}