package com.example.bookmanage.Controller;

import java.util.List;

import javax.validation.Valid;

import com.example.bookmanage.DTO.API;
import com.example.bookmanage.Service.BooksService;
import com.example.bookmanage.model.Books;
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
public class BooksController {

    Logger logger=LoggerFactory.getLogger(BooksController.class);

    private BooksService booksService;

    @GetMapping("/books")
    public ResponseEntity<List<Books>> getBooks(){
        logger.info("getBooks =>called");
        List<Books> tech=booksService.getBooks();
        return ResponseEntity.status(HttpStatus.OK).body(tech);
    }
    @PostMapping("books/add")
    public ResponseEntity<API> addBook(@RequestBody @Valid Books mybook){
        logger.info("addBook =>called");
        booksService.addBook(mybook);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("New Teacher added !",201));
    }

}
