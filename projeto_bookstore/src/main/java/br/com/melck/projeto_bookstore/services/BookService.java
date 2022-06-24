package br.com.melck.projeto_bookstore.services;

import br.com.melck.projeto_bookstore.entities.Book;
import br.com.melck.projeto_bookstore.entities.Category;
import br.com.melck.projeto_bookstore.repositories.BookRepository;
import br.com.melck.projeto_bookstore.services.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryService categoryService;

    public List<Book> findAll(Long id_cat){
        categoryService.findById(id_cat);
        return bookRepository.findAllByCategory(id_cat);
    }

    public Book findById(Long id) {
        Optional<Book> b = bookRepository.findById(id);
        return  b.orElseThrow(() -> new ObjectNotFoundException("Objeto id:" + id + " não foi encontrado")); 
    }

    public Book create(Long id_cat, Book b) {
        b.setId(null);
        Category cat = categoryService.findById(id_cat);
        b.setCategory(cat);
        return bookRepository.save(b); 
    }

    public Book update(Long id, Book book) {
        Book newBook = findById(id);
        newBook.setAuthor(book.getAuthor());
        newBook.setPages(book.getPages());
        newBook.setTitle(book.getTitle());
        newBook.setPublicated(book.getPublicated());
        return bookRepository.save(newBook);
    }

}
