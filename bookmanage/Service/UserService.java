package com.example.bookmanage.Service;
import java.util.List;

import com.example.bookmanage.Repository.UserRepository;
import com.example.bookmanage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User myuser) {
        userRepository.save(myuser);
    }
}
