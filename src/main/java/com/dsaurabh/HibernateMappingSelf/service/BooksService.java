package com.dsaurabh.HibernateMappingSelf.service;

import com.dsaurabh.HibernateMappingSelf.entity.Books;
import com.dsaurabh.HibernateMappingSelf.repository.BooksRepository;
import com.dsaurabh.HibernateMappingSelf.request.CreateNewBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BooksService {

    @Autowired
    private BooksRepository repository;

    public Books addNewBook(CreateNewBookRequest request){
        Optional<Books> existingBook = repository.findByBookName(request.getBookName());
        if(existingBook.isPresent())
            throw new RuntimeException("Duplicate Book Found");

        return saveOrUpdate(request.toBook());
    }

    private Books saveOrUpdate(Books toBook) {
        return repository.save(toBook);
    }

    public Books getBookById(String bookId) {
        Optional<Books> book = repository.findById(UUID.fromString(bookId));

        if(book.isEmpty())
            throw new RuntimeException("Book Not found");
        return book.get();
    }

    public List<Books> findAllBooksById(List<UUID> bookIds) {
        return repository.findAllById(bookIds);
    }
}
