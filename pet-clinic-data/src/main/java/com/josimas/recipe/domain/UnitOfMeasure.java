package com.josimas.recipe.domain;

import lombok.Data;

import javax.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Entity
@Document
public class UnitOfMeasure extends BaseEntity{
    private String description;
}
