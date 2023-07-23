package com.geekster.UserManagement.service;

import com.geekster.UserManagement.model.User;
import com.geekster.UserManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;



    public List<User> getAllUsers() {
        return userRepo.getUsers();
    }

    public String createUsers(List<User> users) {

        List<User> originalList = getAllUsers();
        originalList.addAll(users);
        return "new users added successfully";
    }

    public String createUser(User user) {
        List<User> originalList = getAllUsers();
        originalList.add(user);
        return "new user added successfully";
    }

    public String removeUser(Integer id) {
        List<User> originalList = getAllUsers();
        for(User u : originalList){
            if(id.equals(u.getUserId())){
                originalList.remove(u);
                return "user removed";
            }
        }
        return "User with this id not found";
    }

    public String updateEmail(Integer id, String emailId) {
        List<User> originalList = getAllUsers();
        for(User u : originalList){
            if(id.equals(u.getUserId())){
                u.setUserEmail(emailId);
                return "Email id successfully updated";
            }
        }
        return "User with this id not found";
    }
}
