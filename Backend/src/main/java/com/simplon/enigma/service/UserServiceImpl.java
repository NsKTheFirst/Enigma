package com.simplon.enigma.service;

import com.simplon.enigma.model.Person;
import com.simplon.enigma.model.Piece;
import com.simplon.enigma.model.Score;
import com.simplon.enigma.repository.PieceRepository;
import com.simplon.enigma.repository.ScoreRepository;
import com.simplon.enigma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    PieceRepository pieceRepository;

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

    public Page<Score> findAll(Integer size, Integer page) {
        Pageable pageable = PageRequest.of(page, size);
        return scoreRepository.findAll(pageable);
    }

    public void saveScore(Score score) {
        //Person person = userRepository.findById(id).get();
        //Score scoreToSave = new Score(person.getId(), value);
        scoreRepository.save(score);
    }

    public Piece findPieceByNumPage(Integer numPage) {
        return pieceRepository.findAllByNumPage(numPage);
    }

    public Person findOnePerson(String name) {

        Person personToReturn = userRepository.findByUsername(name);
        //List<Score> scores =scoreRepository.findAllByPersonId(id);
        //personToReturn.setScores(scores);
        return personToReturn;
    }

    public void saveScores(Integer value, UUID id) {
        Person person = userRepository.findById(id).get();
        Score scoreToSave = new Score(person, value);
        scoreRepository.save(scoreToSave);
    }
}

