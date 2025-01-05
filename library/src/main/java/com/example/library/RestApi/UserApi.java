package com.example.library.RestApi;

import com.example.library.Business.UserI;
import com.example.library.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book_user")
public class UserApi {
    private final UserI userI;

    @Autowired
    public UserApi(UserI userI) {
        this.userI = userI;
    }

    @PostMapping("/add")
    public void add(@RequestBody User user){
        this.userI.add(user);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user){
        this.userI.update(user);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Long id){
        this.userI.delete(id);
    }

    @GetMapping("/list")
    public List<User> getAll(){
        return this.userI.getAll();
    }

    @GetMapping("/byId")
    public Optional<User> getById(@RequestParam Long id){
        return this.userI.getById(id);
    }

}
