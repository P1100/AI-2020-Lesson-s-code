package it.polito.ai.boot1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class Home_Controller {

    @GetMapping("/index.html")
    public String index(Model m) {
        System.out.println("-------Chiamata a pagina index.html da index()");
        m.addAttribute("date", new Date());
        return("home");
    }
}
