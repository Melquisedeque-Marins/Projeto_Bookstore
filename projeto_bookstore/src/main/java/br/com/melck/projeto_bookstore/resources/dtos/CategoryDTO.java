package br.com.melck.projeto_bookstore.resources.dtos;

import java.io.Serializable;

import br.com.melck.projeto_bookstore.entities.Category;

public class CategoryDTO implements Serializable{
    
    private Long id;
    private String category;

    public CategoryDTO() {
    }

    public CategoryDTO(Category obj) {
        this.id = obj.getId();
        this.category = obj.getCategory();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}
