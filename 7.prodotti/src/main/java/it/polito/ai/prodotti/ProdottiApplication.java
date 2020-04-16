package it.polito.ai.prodotti;

import it.polito.ai.prodotti.repositories.IngredientRepository;
import it.polito.ai.prodotti.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProdottiApplication {
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner runner(ProductRepository repopr, IngredientRepository repo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
 /*               IngredientEntity p1 = new IngredientEntity();
                p1.setId("i1");
                p1.setName("zucchero");
                repo.save(p1);
                IngredientEntity p2 = new IngredientEntity();
                p2.setId("i2");
                p2.setName("farine");
                repo.save(p2);

                ProductEntity pr1 = new ProductEntity();
                pr1.setId("pr1");
                pr1.setName("Torta");
                repopr.save(pr1);
                ProductEntity pr2 = new ProductEntity();
                pr2.setId("pr2");
                pr2.setName("Pizza");
                repopr.save(pr2);

                repopr.flush();
                repo.flush();
                repo.findAll().stream().forEach(i -> System.out.println(i.toString()));*/
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ProdottiApplication.class, args);
    }
}
