package com.simplon.enigma.service;

import fr.formation.students.dtos.UserCreateDto;
import fr.formation.students.dtos.UserUpdateDto;
import fr.formation.students.dtos.UserViewDto;
import org.springframework.data.domain.Page;


public interface UserService {
    void createUser(UserCreateDto user);
    void delete(Long id);

    Page<UserViewDto> findAll(Integer size, Integer page);

    void update(UserUpdateDto user);
}
