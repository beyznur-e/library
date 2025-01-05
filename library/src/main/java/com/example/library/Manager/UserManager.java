package com.example.library.Manager;
import com.example.library.Business.UserI;
import com.example.library.Data.UserData;
import com.example.library.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserManager implements UserI {

    private final UserData userData;

    @Autowired
    public UserManager(UserData userData){
        this.userData = userData;
    }

    @Override
    public void add(User user) {
       this.userData.save(user);
    }

    @Override
    public void update(User user) {
        userData.save(user);
    }

    @Override
    public void delete(Long id) {
        userData.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return this.userData.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return userData.findById(id);
    }
}
