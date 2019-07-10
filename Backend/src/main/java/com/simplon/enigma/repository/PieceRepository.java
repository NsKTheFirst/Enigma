package com.simplon.enigma.repository;

import com.simplon.enigma.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Fadi NOUFAL
 */
@Repository
public interface PageRepository extends JpaRepository<Person, UUID> {

}
