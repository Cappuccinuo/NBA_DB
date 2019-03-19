package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "lotr_book")
@EntityListeners(AuditingEntityListener.class)

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    @NotBlank
    private String title;
    @NotBlank
    private Integer encounters_count;

    public Book() {
        super();
    }

    public Book(Long id, String title, Integer encounters_count) {
        super();
        this.book_id = id;
        this.title = title;
        this.encounters_count = encounters_count;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long id) {
        this.book_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEncounters_count() {
        return encounters_count;
    }

    public void setEncounters_count(Integer time) {
        this.encounters_count = time;
    }
}
