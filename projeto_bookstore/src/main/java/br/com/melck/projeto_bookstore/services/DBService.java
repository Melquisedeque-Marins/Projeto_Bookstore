package br.com.melck.projeto_bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melck.projeto_bookstore.entities.Book;
import br.com.melck.projeto_bookstore.entities.Category;
import br.com.melck.projeto_bookstore.repositories.BookRepository;
import br.com.melck.projeto_bookstore.repositories.CategoryRepository;

@Service
public class DBService {

    @Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

    
    public void instanciaBaseDeDados(){
        Category cat1 = new Category(null, "Romance");
		Category cat2 = new Category(null, "Informatica");
		Book b1 = new Book(null, "O jogador", "Fiodor Dostoievsk", 500, 1908, cat1);
		Book b2 = new Book(null, "O vôo da vespa", "Ken Follet", 680, 1986, cat1);
		Book b3 = new Book(null, "A arte da guerra", "Sun Tzu", 360, 1650, cat1);
		Book b4 = new Book(null, "Clean Code", "Robert Martin", 560, 2005, cat2);

		cat1.getBooks().addAll(Arrays.asList(b1, b2));
		cat2.getBooks().addAll(Arrays.asList(b3)); 

		this.categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		this.bookRepository.saveAll(Arrays.asList(b1,b2,b3,b4));

    }
}
