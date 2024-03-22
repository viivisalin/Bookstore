package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist";
    }
    
    @GetMapping("categorylist/add")
    public String showAddCategoryForm() {
        return "categorylist/add";
    }

    @PostMapping("categorylist/add")
    public String addCategory(@RequestParam("name") String name) {
        Category category = new Category(null, name);
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }
}
