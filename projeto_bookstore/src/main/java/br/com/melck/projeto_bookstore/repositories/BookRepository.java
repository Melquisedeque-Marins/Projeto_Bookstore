package br.com.melck.projeto_bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.melck.projeto_bookstore.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    @Query("SELECT obj FROM Book obj WHERE obj.category.id = :id_cat ORDER BY title")
    List<Book> findAllByCategory(@Param(value = "id_cat") Long id_cat);

   
    
}
