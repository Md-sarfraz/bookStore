package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookStore.entities.Book;
import com.bookStore.service.BookService;

@Controller
public class bookController {

    @Autowired
    private BookService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/register-book")
    public String bookRegister(@ModelAttribute Book book, BindingResult result) {
        if (result.hasErrors()) {
            // Handle validation errors (e.g., return to form)
            System.out.println(result);
            return "errorPage";
        }
        return "bookRegister";
    }

    @GetMapping("/available-books")
    public String getAllBook(@ModelAttribute Book book, BindingResult result) {
        if (result.hasErrors()) {
            // Handle validation errors (e.g., return to form)
            System.out.println("available-books"+result);
            return "errorPage";
        }
        return "bookList";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b, BindingResult result) {
        System.out.println(b);
        if (result.hasErrors()) {
            // Handle validation errors (e.g., return to form)
            System.out.println(result);
            return "errorPage";
        }
        service.save(b);
        return "redirect:/available-books";
    }
}
