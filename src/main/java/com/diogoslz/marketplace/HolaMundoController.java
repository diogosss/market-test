package com.diogoslz.marketplace;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HolaMundoController {

    @GetMapping("/hola")
    public String saludar(){
        return "<h1>Nunca pares de aprender</h1>";
    }
}
