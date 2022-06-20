package br.com.melck.projeto_bookstore;

import br.com.melck.projeto_bookstore.entities.Book;
import br.com.melck.projeto_bookstore.entities.Category;
import br.com.melck.projeto_bookstore.repositories.BookRepository;
import br.com.melck.projeto_bookstore.repositories.CategoryRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ProjetoBookstoreApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoBookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Literatura", "Romance");

		Book b1 = new Book(null, "O jogador", "Fiodor Dostoievsk", 500, 1908, cat1);
		Book b2 = new Book(null, "O vôo da vespa", "Ken Follet", 680, 1986, cat1);

		cat1.getBooks().addAll(Arrays.asList(b1, b2));
		

		this.categoryRepository.saveAll(Arrays.asList(cat1));
		this.bookRepository.saveAll(Arrays.asList(b1,b2));
		
	}

}
