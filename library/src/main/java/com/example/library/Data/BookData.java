package com.example.library.Data;

import com.example.library.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookData extends JpaRepository<Book,Long> {
}
