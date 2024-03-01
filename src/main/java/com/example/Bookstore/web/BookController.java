package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.model.BookRepository;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;
    
    @RequestMapping(value="/books", method=RequestMethod.GET)
    public String showIndex(Model model) {
    	System.out.println("Books");
        return "books";
    }
}
