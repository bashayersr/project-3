package com.example.bookmanage.Repository;


import com.example.bookmanage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {

}
