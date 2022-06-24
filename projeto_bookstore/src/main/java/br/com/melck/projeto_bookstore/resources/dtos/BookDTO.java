package br.com.melck.projeto_bookstore.resources.dtos;

import java.io.Serializable;

import br.com.melck.projeto_bookstore.entities.Book;

public class BookDTO implements Serializable {
    
    private Long id;
    private String title;
    private String author;
    
    public BookDTO() {
    }

    public BookDTO(Book obj) {
        this.id = obj.getId();
        this.title = obj.getTitle();
        this.author = obj.getAuthor();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    
}
