package com.simplon.enigma.controller;

import com.simplon.enigma.model.Person;
import com.simplon.enigma.model.Piece;
import com.simplon.enigma.model.Score;
import com.simplon.enigma.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    protected String helloWorld() {
        return "hello world";
    }

    @GetMapping("/userProfile")
    public Person findOnePerson(@RequestParam String name){
        return userService.findOnePerson(name);
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

    @DeleteMapping("/{id}")
    protected void delete(@PathVariable("id") UUID id){
        userService.delete(id);
    }

    @GetMapping("/dashboard")
    public Page<Score> findAll(@RequestParam(value = "s", required = false) Integer size,
                                  @RequestParam("p") Integer page){
        Integer checkedSize = (size == null ? 5 : size);

        return userService.findAll(checkedSize, page);
    }

    @PostMapping("/saveScores")
    public void saveScor(@RequestParam Integer value,@RequestParam UUID id ){
        userService.saveScores(value, id);
    }

    @PostMapping("/saveScore")
    public void saveScore(@RequestBody Score score){
        userService.saveScore(score);
    }

    @GetMapping("/page")
    public Piece findPage(@RequestParam Integer numPage){
        return userService.findPieceByNumPage(numPage);
    }


    // request method to create a new account by a guest
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody Person newUser) {

        return new ResponseEntity<Person>(userService.createUser(newUser), HttpStatus.CREATED);
    }

    // this is the login api/service
    @CrossOrigin
    @RequestMapping("/login")
    public Principal user(Principal principal) {
        logger.info("user logged "+principal);
        return principal;
    }

}
