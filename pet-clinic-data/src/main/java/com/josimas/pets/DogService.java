package com.josimas.pets;

import com.josimas.projectone.owner.Pet;

import java.util.Set;

public class DogService implements PetService{
    @Override
    public String getPetType() {
        return "Dogs are the best";
    }

    @Override
    public Set<Pet> findAll() {
        return null;
    }

    @Override
    public Pet findById(Long aLong) {
        return null;
    }

    @Override
    public Pet save(Pet object) {
        return null;
    }

    @Override
    public void delete(Pet object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
