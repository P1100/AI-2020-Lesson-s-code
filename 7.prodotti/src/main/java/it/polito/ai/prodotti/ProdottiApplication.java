package it.polito.ai.prodotti;

import it.polito.ai.prodotti.entities.IngredientEntity;
import it.polito.ai.prodotti.repositories.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProdottiApplication {

    @Bean
    CommandLineRunner runner(IngredientRepository repo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                IngredientEntity p1 = new IngredientEntity();
                p1.setId("i1");
                p1.setName("zucchero");
                repo.save(p1);
                IngredientEntity p2 = new IngredientEntity();
                p2.setId("i2");
                p2.setName("farine");
                repo.save(p2);

                repo.findAll().stream().forEach(i -> System.out.println(i.toString()));
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ProdottiApplication.class, args);
    }
}
