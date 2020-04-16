package it.polito.ai.prodotti.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    private String id;

    private String name;

    private String testcolumnent;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // (targetEntity = IngredientEntity.class)
    @JoinTable(name = "product_ingredient",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<IngredientEntity> ingredientEntities = new ArrayList<>();
}
