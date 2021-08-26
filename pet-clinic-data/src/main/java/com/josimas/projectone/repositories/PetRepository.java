package com.josimas.projectone.repositories;

import com.josimas.projectone.owner.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {



}
