package com.example.bookmanage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name="User")
public class User {

    public  User() {
    }

    @Id
    @NotEmpty(message = "id is required")
    @Column(name="id",nullable=false)
    private Integer id;

    @NotEmpty(message = "name is required")
    @Column(name="name",nullable=false)
    private String name;

    @NotEmpty(message = "password is required")
    @Column(name="password",nullable=false)
    private String password;

    public User(@NotEmpty(message = "id is required") Integer id, @NotEmpty(message = "name is required") String name,
                @NotEmpty(message = "password is required") String password) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
