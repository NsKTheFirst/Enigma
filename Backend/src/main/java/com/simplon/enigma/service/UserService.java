package com.simplon.enigma.service;


import com.simplon.enigma.model.Person;

import java.util.UUID;

public interface UserService {

    void createUser(Person person);
    void delete(UUID id);
    void update(Person person);
}
