package com.example.bookmanage.Service;


import java.util.List;

import com.example.bookmanage.Repository.BooksRepository;
import com.example.bookmanage.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;
    public List<Books> getBooks() {
        return booksRepository.findAll();
    }

    public void addBook(Books mybook) {
        booksRepository.save(mybook);
    }
}
