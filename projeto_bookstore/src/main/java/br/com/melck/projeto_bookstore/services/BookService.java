package br.com.melck.projeto_bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melck.projeto_bookstore.entities.Book;
import br.com.melck.projeto_bookstore.repositories.BookRepository;
import br.com.melck.projeto_bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> b = bookRepository.findById(id);
        return  b.orElseThrow(() -> new ObjectNotFoundException("Objeto id:" + id + " não foi encontrado")); 
    }
    
}
