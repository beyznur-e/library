package com.example.library.Business;

import com.example.library.Entity.Book;
import com.example.library.Entity.User;

import java.util.List;
import java.util.Optional;

public interface BookI {
    void add(Book book);
    void update(Book book);
    void delete(Long id);
    List<Book> getAll();
    Optional<Book> getById(Long id);

}
