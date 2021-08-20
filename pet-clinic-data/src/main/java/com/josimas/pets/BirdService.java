package com.josimas.pets;

public class BirdService implements PetService{
    @Override
    public String getPetType() {
        return "Birds are the best";
    }
}
