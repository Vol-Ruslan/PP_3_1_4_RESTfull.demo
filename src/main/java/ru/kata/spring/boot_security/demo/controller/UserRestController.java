package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.model.User;


import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

//    private final UserDetailsService userDetailsService;

    private final UserService userService;

    public UserRestController(UserService userService) {
//        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.allUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PostMapping()
    public void addNewUser(@RequestBody User user) {
        userService.add(user);
    }

    @PutMapping()
    public void saveUser(@RequestBody User user) {
        userService.edit(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @GetMapping("/authUser")
    public UserDetails authUser(Principal principal) {
        return userService.findByEmail(principal.getName());
    }
}
