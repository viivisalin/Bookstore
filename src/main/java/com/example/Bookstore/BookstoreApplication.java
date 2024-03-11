package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bRepository, CategoryRepository cRepository) {
		return (args) -> {
			log.info("save some sample categories");
			cRepository.save(new Category(1, "Scifi"));
			cRepository.save(new Category(2, "Comic"));
			cRepository.save(new Category(3, "Fiction"));

			bRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, null, "1232323-21",24.95));
			bRepository.save(new Book("Animal Farm", "George Orwell", 1945, null, "2212343-5", 24.95));
			bRepository.save(new Book("Juurihoito", "Miika Nousiainen", 2016, null, "978-951-1-29389-7", 24.95));
			bRepository.save(new Book("Ihmisen osa", "Kari Hotakainen", 2009, null, "978-952-2-34077-1", 24.95));

			log.info("fetch all books");
			for (Book book : bRepository.findAll()) {
				log.info(book.toString());
			}

			
		};
	}

}
