package com.example.bookmanage.Controller;

import java.util.List;

import javax.validation.Valid;

import com.example.bookmanage.DTO.API;
import com.example.bookmanage.Service.UserService;
import com.example.bookmanage.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("management")
@RequiredArgsConstructor
public class UserController {

    Logger logger=LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUsers(){
        logger.info("getUsers =>called");
        List<User> user=userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @PostMapping("user/add")
    public ResponseEntity<API> addUser(@RequestBody @Valid User myuser){
        logger.info("adduser =>called");
        userService.addUser(myuser);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("New User added !",201));
    }
}
