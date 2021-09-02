package com.josimas.recipe.services;

import com.josimas.projectone.services.CrudService;
import com.josimas.recipe.commands.UnitOfMeasureCommand;
import com.josimas.recipe.domain.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService extends CrudService<UnitOfMeasure, Long> {
    Set<UnitOfMeasureCommand> listAllUoms();
}
