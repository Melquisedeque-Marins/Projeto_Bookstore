package br.com.melck.projeto_bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.melck.projeto_bookstore.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
