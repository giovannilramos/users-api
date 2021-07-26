package br.com.giovanni.users.controllers;

import br.com.giovanni.users.entities.User;
import br.com.giovanni.users.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin(allowedHeaders = "*")
public class UserController {

    @Autowired
    private final UserService objService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() throws Exception {
        List<User> users = objService.getTodos();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user) throws Exception {
        User objUser = objService.insert(user);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("todo", "/users" + objUser.getId().toString());
        return new ResponseEntity<>(objUser, httpHeaders, HttpStatus.CREATED);
    }
}
