package com.example.library.RestApi;

import com.example.library.Business.DTO.Owned_Book_User_Dto;
import com.example.library.Entity.Owned_Book_User;
import com.example.library.Manager.Owned_Book_User_Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owned-book-user")
public class Owned_Book_User_Api {

    private final Owned_Book_User_Manager ownedBookUserManager;

    @Autowired
    public Owned_Book_User_Api(Owned_Book_User_Manager ownedBookUserManager) {
        this.ownedBookUserManager = ownedBookUserManager;
    }

    @PostMapping("/add")
    public void addBookToUser(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String bookName,
                              @RequestParam String bookType,
                              @RequestParam Long pagesNumber) {
        ownedBookUserManager.addBookToUser(firstName, lastName, bookName, bookType, pagesNumber);
    }


    @GetMapping("/list")
    public ResponseEntity<?> listAll() { //<?> kullanımı sayesinde, her durumda dönecek gövdenin türü değişebilir.
        try {
            List<Owned_Book_User_Dto> ownedBooks = ownedBookUserManager.getAllOwnedBooks();

            if (ownedBooks.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT) //HTTP durumu olarak 204 No Content döndürülür. Bu, "istek başarılı, ancak içerik yok" anlamına gelir.
                        .body("No owned books found.");
            }

            return ResponseEntity.ok(ownedBooks); //HTTP durumu olarak 200 OK döner.
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)  //HTTP durumu olarak 500 Internal Server Error döner. Bu, "sunucuda bir hata oluştu" anlamına gelir.
                    .body("An error occurred while fetching the owned books: " + e.getMessage());
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBookFromUser(@RequestBody Owned_Book_User_Dto dto) {
        try {
            // Manager sınıfındaki delete metodunu çağır
            ownedBookUserManager.deleteBookFromUser(dto.getUser_id(), dto.getBook_id());
            return ResponseEntity.ok("User and book relationship deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to delete user and book relationship.");
        }
    }
}
