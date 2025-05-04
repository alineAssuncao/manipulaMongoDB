package com.spring.mongo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import org.bson.Document;

@RestController
@RequestMapping("/mongo") // Define que todos os endpoints começam com "/mongo"
public class MongoController {

    @Value("${spring.data.mongodb.collection}")
    private String collection;

    private final MongoTemplate mongoTemplate; // MongoDB nativo

    public MongoController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/consulta") // Define a rota "/mongo/consulta"
    public String consultaMongo() {
        return "Consulta ao MongoDB realizada!";
    }

    @GetMapping("/consulta/{id}") // Consulta dinamica no mongo"
    public Document consultaMongoId(@PathVariable String id) {
        return mongoTemplate.findOne(
                new org.springframework.data.mongodb.core.query.Query(
                        org.springframework.data.mongodb.core.query.Criteria.where("id").is(id)
                ), org.bson.Document.class, collection
        );
    }
}