package com.example.librarymanagement.controller;

import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @PostMapping
    public void registerNewAuthor(@RequestBody Author author){
        authorService.addNewAuthor(author);
    }

    @DeleteMapping("{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Long authorId){
        authorService.deleteAuthor(authorId);
    }

    @PutMapping(path = "{authorId}")
    public void updateAuthor(
            @PathVariable("authorId") Long authorId,
            @RequestParam(required = false) String authorName){
        authorService.updateAuthor(authorId, authorName);
    }
}
