package com.josimas.pets;

public class DogService implements PetService{
    @Override
    public String getPetType() {
        return "Dogs are the best";
    }
}
