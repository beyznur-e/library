package com.example.library.Manager;

import com.example.library.Business.DTO.Owned_Book_User_Dto;
import com.example.library.Data.BookData;
import com.example.library.Data.Owned_Book_User_Data;
import com.example.library.Data.UserData;
import com.example.library.Entity.Book;
import com.example.library.Entity.Owned_Book_User;
import com.example.library.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Owned_Book_User_Manager{

    private final UserData userData;
    private final BookData bookData;
    private final Owned_Book_User_Data ownedBookUserData;

    @Autowired
    public Owned_Book_User_Manager(UserData userData, BookData bookData, Owned_Book_User_Data ownedBookUserData) {
        this.userData = userData;
        this.bookData = bookData;
        this.ownedBookUserData = ownedBookUserData;
    }

    public void addBookToUser(String firstName, String lastName, String bookName, String bookType, Long pagesNumber) {
        // Kullanıcı oluştur ve kaydet
        User user = new User();
        user.setFirst_name(firstName);
        user.setLast_name(lastName);
        user = userData.save(user);

        // Kitap oluştur ve kaydet
        Book book = new Book();
        book.setName(bookName);
        book.setType(bookType);
        book.setPages_number(pagesNumber);
        book = bookData.save(book);

        // Kullanıcı ve kitap ilişkisini kaydet
        Owned_Book_User ownedBookUser = new Owned_Book_User();
        ownedBookUser.setUserId(user.getId());
        ownedBookUser.setBookId(book.getId());
        ownedBookUserData.save(ownedBookUser);
    }

    // Getirilen kitaplar ile kullanıcı bilgilerini alacak olan metod
    public List<Owned_Book_User_Dto> getAllOwnedBooks() {
        // Tüm Owned_Book_User kayıtlarını al
        List<Owned_Book_User> ownedBooks = ownedBookUserData.findAll();

        // Her Owned_Book_User kaydını DTO'ya dönüştür.Stream API, listedeki her eleman üzerinde işlem yapmamızı sağlar. Map, nesneyi dönüştürür.
        return ownedBooks.stream().map(ownedBookUser -> {
            Owned_Book_User_Dto dto = new Owned_Book_User_Dto();

            // Kullanıcı ve kitap bilgilerini al
            User user = userData.findById(ownedBookUser.getUserId()).orElse(null);
            Book book = bookData.findById(ownedBookUser.getBookId()).orElse(null);

            // DTO'yu doldur
            if (user != null) {
                dto.setUser_id(user.getId());
                dto.setFirstName(user.getFirst_name());
                dto.setLastName(user.getLast_name());
            }
            if (book != null) {
                dto.setBook_id(book.getId());
                dto.setBookName(book.getName());
                dto.setBookType(book.getType());
                dto.setPagesNumber(book.getPages_number());
            }

            return dto;
        }).collect(Collectors.toList());
    }


    public void deleteBookFromUser(Long userId, Long bookId) {
        List<Owned_Book_User> ownedBooks = ownedBookUserData.findByUserIdAndBookId(userId, bookId);
        for (Owned_Book_User ownedBook : ownedBooks) {
            ownedBookUserData.delete(ownedBook);
        }
    }

}
