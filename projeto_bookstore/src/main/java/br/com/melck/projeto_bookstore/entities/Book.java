package br.com.melck.projeto_bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "o campo titulo é obrigatório")
    @Length(min = 5, max = 50, message = "o titulo do livro deve ter entre 1 e 50 caracteres")
    private String title;

    @NotEmpty(message = "o campo autor é obrigatório")
    @Length(min = 5, max = 50, message = "o campo autor do livro deve ter entre 5 e 50 caracteres")
    private String author;

    private Integer pages;

    private Integer publicated;
       
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Category category;

    public Book() {
    }

    

    public Book(Long id, String title, String author, Integer pages, Integer publicated, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.publicated = publicated;
        this.category = category;
    }



    public Integer getPublicated() {
        return publicated;
    }

    public void setPublicated(Integer publicated) {
        this.publicated = publicated;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    

}
