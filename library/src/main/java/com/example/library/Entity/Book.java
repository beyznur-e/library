package com.example.library.Entity;

import jakarta.persistence.*;

//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "pages_number")
    private Long pages_number;

    public Book(){}

    public Book(Long id, String name, String type, Long pages_number) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pages_number = pages_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPages_number() {
        return pages_number;
    }

    public void setPages_number(Long pagesNumber) {
        this.pages_number = pages_number;
    }
}
