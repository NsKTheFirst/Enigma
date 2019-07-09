package com.simplon.enigma.controller;

import com.simplon.enigma.model.Person;
import com.simplon.enigma.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    protected String helloWorld() {
        return "hello world";
    }


    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    protected void create(@Valid @RequestBody Person person) {
        System.out.println(person.toString());
        userService.createUser(person);
    }

    @PutMapping
    protected void update(@Valid @RequestBody Person person) {
        userService.update(person);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    protected void delete(@PathVariable("id") UUID id){
        userService.delete(id);
    }

}
