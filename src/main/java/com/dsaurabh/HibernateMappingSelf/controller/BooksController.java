package com.dsaurabh.HibernateMappingSelf.controller;

import com.dsaurabh.HibernateMappingSelf.entity.Books;
import com.dsaurabh.HibernateMappingSelf.repository.BooksRepository;
import com.dsaurabh.HibernateMappingSelf.request.CreateNewBookRequest;
import com.dsaurabh.HibernateMappingSelf.service.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class BooksController {

    @Autowired
    BooksService service;

    @PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public Books addBook(@RequestBody CreateNewBookRequest request){
        return service.addNewBook(request);

    }

    @GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Books getBookById(@PathVariable(value = "id") String bookId){
        return service.getBookById(bookId);

    }
}
