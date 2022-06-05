package com.example.bookmanage.Repository;


import com.example.bookmanage.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books,Integer> {


}
