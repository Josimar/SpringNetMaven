package com.josimas.recipe.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category extends BaseEntity{
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
