package com.practice.booktrackerdb;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookRepos repos;
    public BookController(BookRepos repos) {
        this.repos = repos;
    }

    @GetMapping
    public List<Book> getBooks() {
        return repos.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repos.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long Id) {
        repos.deleteById(Id);
    }

}
