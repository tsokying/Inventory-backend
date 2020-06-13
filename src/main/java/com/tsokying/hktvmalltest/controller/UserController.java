package com.tsokying.hktvmalltest.controller;

import com.tsokying.hktvmalltest.model.User;
import com.tsokying.hktvmalltest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.tsokying.hktvmalltest.controller.ErrorController.getResponseEntity;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user, BindingResult result) {
        ResponseEntity<?> errorMap = getResponseEntity(result);
        if (errorMap != null) return errorMap;
        User newUser = userService.addOrUpdateUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<User> getAllUser(){
        return userService.findAllUser();
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getById(@PathVariable Long user_id) {
        User user = userService.findUserById(user_id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long user_id) {
        userService.deleteUser(user_id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
