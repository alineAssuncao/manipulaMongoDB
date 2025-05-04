package com.sprint.mongo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mongo") // Define que todos os endpoints começam com "/mongo"
public class MongoController {

    @GetMapping("/consulta") // Define a rota "/mongo/consulta"
    public String consultaMongo() {
        return "Consulta ao MongoDB realizada!";
    }
}