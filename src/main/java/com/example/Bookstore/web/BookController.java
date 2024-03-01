package com.example.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;
    
    @RequestMapping(value="/books", method=RequestMethod.GET)
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

}
