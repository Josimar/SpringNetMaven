package com.josimas.pets;

import com.josimas.projectone.owner.Pet;
import com.josimas.projectone.services.CrudService;

public interface PetService extends CrudService<Pet, Long>  {

    String getPetType();

}
