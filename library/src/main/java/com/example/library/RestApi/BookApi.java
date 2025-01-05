package com.example.library.RestApi;

import com.example.library.Business.BookI;
import com.example.library.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookApi {
    private final BookI bookI;

    @Autowired
    public BookApi(BookI bookI) {
        this.bookI = bookI;
    }

    @PostMapping("/add")
    public void add(@RequestBody Book book){
        this.bookI.add(book);
    }

    @PostMapping("/update")
    public void update(@RequestBody Book book){
        this.bookI.update(book);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Long id){
        this.bookI.delete(id);
    }

    @GetMapping("/list")
    public List<Book> getAll() {
        return bookI.getAll();
    }

    @GetMapping("/byId")
    public Optional<Book> getById(@RequestParam Long id){
        return this.bookI.getById(id);
    }

}