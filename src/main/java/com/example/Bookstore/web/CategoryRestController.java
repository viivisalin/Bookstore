package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;

@CrossOrigin
@Controller
public class CategoryRestController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value="/categories", method = RequestMethod.GET)
    public @ResponseBody List<Category> getCategoriesRest() {
        return (List<Category>) categoryRepository.findAll();
    }

    @RequestMapping(value="/categories/{id}", method = RequestMethod.GET) 
    public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @RequestMapping(value="/categories", method = RequestMethod.POST)
    public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

}
