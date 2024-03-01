package com.example.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;
    
    @RequestMapping(value="/books")
    public String showBooks(Model model) {
    	System.out.println("Books");
        return "books";
    }
    
    @RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String showBookList(Model model) {
        List<Book> books = (List<Book>) bookRepository.findAll();
    	System.out.println("Book List");
        return "booklist";
    }

    @GetMapping("/books/add")
    public String showAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }
}
