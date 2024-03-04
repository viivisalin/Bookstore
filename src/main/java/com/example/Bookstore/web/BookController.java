package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String BookList(Model model) {
        model.addAttribute("books", bookRepository.findAll()); 
        return "bookList";
    }

    @GetMapping("/booklist/add")
    public String showAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "redirect:/booklist";
    }

    @GetMapping("booklist/save")
    public String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/booklist/edit/{id}")
    public String editBook(@PathVariable("id") Long bookid, Model model) {
        Book existingBook = bookRepository.findById(bookid).orElse(null);
         if (existingBook != null) {
            model.addAttribute("book", existingBook);
            return "editBook";
         } else {
            return "error";
         }
    }

    @GetMapping("/booklist/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookid) {
        bookRepository.deleteById(bookid);
        return "redirect:/booklist";
    }
}
