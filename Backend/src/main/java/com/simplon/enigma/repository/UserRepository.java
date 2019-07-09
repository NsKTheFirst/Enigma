package com.simplon.enigma.repository;

import com.simplon.enigma.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Person, UUID> {

    Person findByUsername(String username);
}
