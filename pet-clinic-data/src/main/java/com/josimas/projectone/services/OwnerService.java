package com.josimas.projectone.services;

import com.josimas.projectone.owner.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
