package runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;

public class BookCommandLineRunner implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        // Insert example data
        Book book1 = new Book("Example Title 1", "Example Author 1", 2022, "1234567890", 29.99);
        Book book2 = new Book("Example Title 2", "Example Author 2", 2023, "0987654321", 39.99);

        bookRepository.save(book1);
        bookRepository.save(book2);

        System.out.println("Example data inserted into the database.");
    }

}
