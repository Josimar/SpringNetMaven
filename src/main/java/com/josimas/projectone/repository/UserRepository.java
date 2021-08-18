package com.josimas.projectone.repository;

import com.josimas.projectone.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
