package it.polito.ai.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;

@RestController
public class HomeController {
    @GetMapping("/")
    public it.polito.ai.security.MyData home(Principal principal) {
        return MyData.builder()
                   .name(principal != null ? principal.getName() : "<NO NAME>") //.name("Prova")x
                   .date(new Date())
                   .build();
    }
}
