package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value="/books", method=RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest (@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }

    @RequestMapping(value="/books", method = RequestMethod.POST)
    public @ResponseBody Book saveBookRest (@RequestBody Book book) {
        return bookRepository.save(book);
    }
    

}
