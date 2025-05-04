package controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Bem-vindo à API de MongoDB!";
    }
}