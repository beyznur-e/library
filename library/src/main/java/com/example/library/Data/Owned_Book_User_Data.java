package com.example.library.Data;

import com.example.library.Entity.Owned_Book_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Owned_Book_User_Data extends JpaRepository<Owned_Book_User, Long> {
    List<Owned_Book_User> findByUserIdAndBookId(Long userId, Long bookId);
}
