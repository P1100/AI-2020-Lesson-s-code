package it.polito.ai.boot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Boot1Application {

    @Bean
    public Date bean_method_name_doesnt_matter() {
        return new Date();
    }
    @Bean
    public List<String> items(Date date_loaded_from_bean_last) {
        return Stream.of("alfa","beta","gamma", date_loaded_from_bean_last.toString()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        //System.out.println(" ".isBlank()); //java11 method, ****true
        ApplicationContext ctx = SpringApplication.run(Boot1Application.class, args);
        String[] beanNames = ctx.getBeanDefinitionNames(); // nome di tutti i bean definiti
        Arrays.sort(beanNames);
        for (String name : beanNames) {
            System.out.println(name);
        }
    }
}
