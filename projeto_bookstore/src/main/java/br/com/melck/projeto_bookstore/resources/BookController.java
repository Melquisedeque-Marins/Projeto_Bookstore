package br.com.melck.projeto_bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.melck.projeto_bookstore.entities.Book;
import br.com.melck.projeto_bookstore.resources.dtos.BookDTO;
import br.com.melck.projeto_bookstore.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Book book = bookService.findById(id);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(@RequestParam (value = "category", defaultValue = "0") Long id_cat){
        List<Book> list = bookService.findAll(id_cat);
        List<BookDTO> listDTO = list.stream()
        .map(BookDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestParam(value = "category", defaultValue = "0") Long id_cat, @RequestBody Book b){
        Book newBook = bookService.create(id_cat, b);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/books/{id}").buildAndExpand(newBook.getId()).toUri();
        return ResponseEntity.created(uri).build(); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update( @PathVariable Long id, @RequestBody Book book){
        Book newBook = bookService.update(id, book);
        return ResponseEntity.ok().body(newBook);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> updatePatch( @PathVariable Long id, @RequestBody Book book){
        Book newBook = bookService.update(id, book);
        return ResponseEntity.ok().body(newBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}