package it.polito.ai.prodotti.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class IngredientEntity {
    @Id
    private String id;
    private String name;
}
