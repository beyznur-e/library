package com.example.library.Business.DTO;

public class Owned_Book_User_Dto {
    private Long user_id;
    private Long book_id;
    private String firstName;
    private String lastName;
    private String bookName;
    private String bookType;
    private Long pagesNumber;

    // Getter ve Setter'lar
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Long getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(Long pagesNumber) {
        this.pagesNumber = pagesNumber;
    }
}
