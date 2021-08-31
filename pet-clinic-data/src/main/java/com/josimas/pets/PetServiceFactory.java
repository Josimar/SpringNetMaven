package com.josimas.pets;

public class PetServiceFactory {

    public PetService getPetService(String petType){
        switch (petType){
            case "dog":
                return new DogService(null);
            case "cat":
                return new CatService(null);
            default:
                return new BirdService(null);
        }
    }

}
