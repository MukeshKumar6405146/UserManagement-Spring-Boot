package com.geekster.UserManagement.controller;

import com.geekster.UserManagement.model.User;
import com.geekster.UserManagement.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;


    //get all users
   @GetMapping("users")
    List<User> getAllUsers(){
     return userService.getAllUsers();
    }

    //create users

    @PostMapping("users")
    String addUsers(@Valid @RequestBody List<User> users){
          return userService.createUsers(users);
    }

    //create only one user
    @PostMapping("user")
    String addUser(@Valid @RequestBody User user){
       return userService.createUser(user);
    }

    //Delete user
    @DeleteMapping("user/{id}")
    String removeUser(@PathVariable Integer id) {
       return userService.removeUser(id);
    }

    // update email
    @RequestMapping(value ="user/{id}/email/{emailId}", method = PUT)
    String updateEmail(@PathVariable Integer id, @PathVariable @Email String emailId){
       return userService.updateEmail(id,emailId);
    }
}
