package fr.formation.students.controller;

import fr.formation.students.dtos.UserCreateDto;
import fr.formation.students.dtos.UserUpdateDto;
import fr.formation.students.dtos.UserViewDto;
import fr.formation.students.services.UserServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    protected void create(@Valid @RequestBody UserCreateDto user) {
        System.out.println(user.toString());
        userService.createUser(user);
    }

    @PutMapping
    protected void update(@Valid @RequestBody UserUpdateDto user) {
        userService.update(user);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    protected void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }

    @GetMapping("/all")
    @Secured("ROLE_USER")
    protected Page<UserViewDto> findAll(@RequestParam(value = "s", required = false) Integer size,
                                        @RequestParam("p") Integer page){
        Integer checkedSize = (size == null ? 20 : size);

        return userService.findAll(checkedSize, page);
    }
}
