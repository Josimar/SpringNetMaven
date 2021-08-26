package com.josimas.recipe.domain;

import javax.persistence.*;

@Entity
@Table(name = "unitofmeasure")
public class UnitOfMeasure extends BaseEntity{

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
