package it.polito.ai.prodotti.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class ProductEntity {
    @Id
    private String id;

    private String name;

    @ManyToMany
    private List<IngredientEntity> ingredientEntities;
}
