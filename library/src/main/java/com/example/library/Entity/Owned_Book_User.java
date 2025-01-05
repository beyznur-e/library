package com.example.library.Entity;
import jakarta.persistence.*;
import jakarta.persistence.*;

@Entity
@Table(name = "owned_book_user")
public class Owned_Book_User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "book_id")
    private Long bookId;

    public Owned_Book_User() {
    }

    public Owned_Book_User(Long id, Long userId, Long bookId) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
