package com.josimas.recipe.services;

import com.josimas.recipe.commands.UnitOfMeasureCommand;
import com.josimas.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.josimas.recipe.domain.UnitOfMeasure;
import com.josimas.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureServiceImplementation implements UnitOfMeasureService{
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImplementation(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {

        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                        .spliterator(), false)
                .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<UnitOfMeasure> findAll() {
        return null;
    }

    @Override
    public UnitOfMeasure findById(Long aLong) {
        return null;
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure object) {
        return null;
    }

    @Override
    public void delete(UnitOfMeasure object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
