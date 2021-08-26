package com.josimas.recipe.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UnitOfMeasure extends BaseEntity{
    private String description;
}
