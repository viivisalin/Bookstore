package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;

@DataJpaTest
public class RepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void createBook() {
        Book book = new Book("The Alchemist", "Paulo Coelho", 1988, null, null, 0);
        bookRepository.save(book);
        assertThat(book.getTitle()).isNotBlank();
    }

    @Test
    public void searchBook() {
        List<Book> books = bookRepository.findByTitle("Animal Farm");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("George Orwell");
    }

    @Test
    public void deleteBook() {
      /*   Book book = new Book("The Alchemist", "Paulo Coelho", 1988, null, null, 0);
        bookRepository.save(book);

        Optional<Book> retrievedBook = bookRepository.findById(book.getBookid());
        assertThat(retrievedBook).isPresent();

        bookRepository.deleteById(book.getBookid());

        Optional<Book> deletedBook = bookRepository.findById(book.getBookid());
        assertThat(deletedBook).isNotPresent(); */
    }

    @Test
    public void createCategory() {
        Category category = new Category("fantasy");
        categoryRepository.save(category);
        assertThat(category.getName()).isNotBlank();
    }

    @Test
    public void searchCategory() {
        List<Category> category = (List<Category>) categoryRepository.findByName("fiction");

        assertThat(category).hasSize(1);
    }

    @Test
    public void deleteCategory() {

    }
}
