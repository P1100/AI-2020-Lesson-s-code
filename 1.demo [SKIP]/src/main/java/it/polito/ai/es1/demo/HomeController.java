package it.polito.ai.es1.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HomeController {
    @GetMapping
    public Message home() {
        return new Message("benvenuti al corso", LocalDateTime.now());

    }
}
