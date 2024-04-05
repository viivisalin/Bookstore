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
import com.example.Bookstore.model.User;
import com.example.Bookstore.model.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bRepository, CategoryRepository cRepository, UserRepository uRepository) {
		return (args) -> {
			log.info("save some sample categories");
			Category humor = new Category("Humor");
			cRepository.save(humor);
			Category politics = new Category("Politics");
			cRepository.save(politics);
			Category fiction = new Category("Fiction");
			cRepository.save(fiction);

			bRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, fiction, "1232323-21", 24.95));
			bRepository.save(new Book("Animal Farm", "George Orwell", 1945, politics, "2212343-5", 24.95));
			bRepository.save(new Book("Juurihoito", "Miika Nousiainen", 2016, humor, "978-951-1-29389-7", 24.95));
			bRepository.save(new Book("Ihmisen osa", "Kari Hotakainen", 2009, humor, "978-952-2-34077-1", 24.95));

			User user1 = new User("user",
					"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "erkki.esimerkki@sposti.fi", "USER");
			User user2 = new User("admin",
					"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "maija.malli@sposti.com", "ADMIN");
			uRepository.save(user1);
			uRepository.save(user2);

			log.info("fetch all books");
			for (Book book : bRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
