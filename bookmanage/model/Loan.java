package com.example.bookmanage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name="Loan")
public class Loan {

    public  Loan() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotEmpty(message = "id is required")
    @Column(name="id",nullable=false)
    private Integer id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "book_id")
    Books book;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "user_id")
    User user;


    public Loan( Books book, User user) {
        super();
        //this.id = id;
        this.book = book;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
