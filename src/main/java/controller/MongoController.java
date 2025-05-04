package controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mongo")
public class MongoController {

    @GetMapping("/consulta")
    public String consultaMongo() {
        return "Consulta ao MongoDB realizada!";
    }
}