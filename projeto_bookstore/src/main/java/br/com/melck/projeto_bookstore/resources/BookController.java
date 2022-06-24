package br.com.melck.projeto_bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<BookDTO>> findAll(){
        var list = bookService.findAll();
        List<BookDTO> listDTO = list.stream()
        .map(BookDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    
}
