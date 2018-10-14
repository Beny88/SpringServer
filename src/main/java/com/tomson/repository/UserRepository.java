package com.tomson.repository;

import com.tomson.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByFirstNameAndLastName(String firstName, String lastName);
}

