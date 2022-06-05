package com.example.bookmanage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name="Books")
public class Books {

    public  Books() {
    }

    @Id
    @NotEmpty(message = "id is required")
    @Column(name="id",nullable=false)
    private Integer id;

    @NotEmpty(message = "name is required")
    @Column(name="name",nullable=false)
    private String name;

    @NotEmpty(message = "genre is required")
    @Column(name="genre",nullable=false)
    private String genre;


    public Books(@NotEmpty(message = "id is required") Integer id, @NotEmpty(message = "name is required") String name,
                 @NotEmpty(message = "genre is required") String genre) {
        super();
        this.id = id;
        this.name = name;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


}
