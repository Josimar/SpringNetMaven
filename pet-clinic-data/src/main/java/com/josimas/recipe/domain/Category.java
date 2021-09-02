package com.josimas.recipe.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
@Document
public class Category extends BaseEntity{
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
