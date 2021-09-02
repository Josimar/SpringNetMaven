package com.josimas.recipe.services.map;

import com.josimas.recipe.commands.UnitOfMeasureCommand;
import com.josimas.recipe.domain.UnitOfMeasure;
import com.josimas.recipe.services.UnitOfMeasureService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UnitOfMeasureMapService extends AbstractMapService<UnitOfMeasure, Long> implements UnitOfMeasureService {
    @Override
    public Set<UnitOfMeasure> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(UnitOfMeasure object) {
        super.delete(object);
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure object) {
        return super.save(object);
    }

    @Override
    public UnitOfMeasure findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        return null;
    }
}
