package com.example.library.Business;

import com.example.library.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserI {
    void add(User user);
    void update(User user);
    void delete(Long id);
    List<User> getAll();
    Optional<User> getById(Long id);
}
