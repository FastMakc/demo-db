package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired UserRepository userRepository;

    @GetMapping("/createUser")
    User createUser(@RequestParam(value = "name") String name){

        var user = new User();
        user.setName(name);
        userRepository.save(user);


       return userRepository.findById(2).orElse(null);

    }

    @GetMapping("/findUserByName")
    List<User> findUserByName(@RequestParam(value = "name") String name){

    return userRepository.findUserByName(name);

    }

    @GetMapping("/findUserByNameSorted")
    List<User> findUserByNameSorted(@RequestParam(value = "name") String name, @RequestParam(value = "sortBy") String sortBy,
            @RequestParam(value = "direction") String direction){



        return userRepository.findUserByNameSorted(Sort.by(Sort.Direction.fromString(direction), sortBy), name);

    }
}
