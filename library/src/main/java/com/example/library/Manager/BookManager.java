package com.example.library.Manager;

import com.example.library.Business.BookI;
import com.example.library.Data.BookData;
import com.example.library.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookManager implements BookI {
    private BookData bookData;

    @Autowired
    public BookManager(BookData bookData){
        this.bookData = bookData;
    }

    @Override
    public void add(Book book) {
        this.bookData.save(book);
    }

    @Override
    public void update(Book book) {
        this.bookData.save(book);
    }

    @Override
    public void delete(Long id) {
        bookData.deleteById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookData.findAll();
    }

    @Override
    public Optional<Book> getById(Long id) {
        return bookData.findById(id);
    }
}
