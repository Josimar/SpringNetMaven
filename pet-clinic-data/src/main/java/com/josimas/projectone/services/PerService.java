package com.josimas.projectone.services;

import com.josimas.projectone.owner.Pet;

import java.util.Set;

public interface PerService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
