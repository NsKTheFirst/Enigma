package com.simplon.enigma.service;

import com.simplon.enigma.model.Person;
import com.simplon.enigma.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void createUser(Person person) {
        Person personToSave = person;
        String newPass = passwordEncoder.encode(person.getPassword());
        personToSave.setPassword(newPass);
        userRepository.save(personToSave);
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(Person user) {
        Person person = userRepository.findById(user.getId()).get();
        String newPass = passwordEncoder.encode(user.getPassword());
        person.setPassword(newPass);
        userRepository.save(person);
    }



}

