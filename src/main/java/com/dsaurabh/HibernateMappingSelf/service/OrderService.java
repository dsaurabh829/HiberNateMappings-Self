package com.dsaurabh.HibernateMappingSelf.service;

import com.dsaurabh.HibernateMappingSelf.entity.Books;
import com.dsaurabh.HibernateMappingSelf.entity.Order;
import com.dsaurabh.HibernateMappingSelf.entity.User;
import com.dsaurabh.HibernateMappingSelf.repository.OrderRepository;
import com.dsaurabh.HibernateMappingSelf.request.CreateNewOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private BooksService booksService;

    public Order createNewOrder(CreateNewOrderRequest request) {
        Optional<User> existingUser = Optional.ofNullable(userService.getUserById(request.getUserId()));
        if(existingUser.isEmpty())
            throw new RuntimeException("User Not found");

        List<UUID> bookIds = new ArrayList<>();
        Double totalAmount = 0.0;
        for(String bookId : request.getBookIds()){
            Optional<Books> existingBook = Optional.ofNullable(booksService.getBookById(bookId));
            if(existingBook.isEmpty())
                throw new RuntimeException("Book Not found");
            bookIds.add(existingBook.get().getBookId());
            totalAmount += existingBook.get().getBookPrice();
        }

        List<Books> allBooks = booksService.findAllBooksById(bookIds);

        Order order = Order.builder()
                .user(existingUser.get())
                .booksList(allBooks)
                .orderAmount(totalAmount)
                .build();

        return saveOrUpdate(order);

    }

    public Order saveOrUpdate(Order order) {
        return repository.save(order);
    }
}
