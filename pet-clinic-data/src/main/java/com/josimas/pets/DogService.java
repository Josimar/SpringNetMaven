package com.josimas.pets;

import com.josimas.projectone.owner.Pet;
import com.josimas.projectone.repositories.PetRepository;

import java.util.HashSet;
import java.util.Set;

public class DogService implements PetService{
    private final PetRepository petRepository;

    public DogService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public String getPetType() {
        return "Dogs are the best";
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();

        petRepository.findAll().forEach(pets::add);

        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
