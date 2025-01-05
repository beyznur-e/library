package com.example.library.Data;

import com.example.library.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserData extends JpaRepository<User, Long> {
}
