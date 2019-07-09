package com.simplon.enigma.repository;

import com.simplon.enigma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<User, UUID> {

    User findByUserAccountUsername(String userName);
}
