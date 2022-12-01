package com.example.librarymanagement.service;

import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public void addNewAuthor(Author author) {
        Optional<Author> authorOptional = authorRepository.findAuthorByName(author.getAuthorName());
        if (authorOptional.isPresent()){
            throw new IllegalStateException("authorName taken");
        }
        authorRepository.save(author);
    }

    public void deleteAuthor(Long authorId) {
        boolean exists = authorRepository.existsById(authorId);
        if (!exists){
            throw new IllegalStateException("author with id" + authorId + " does not exists");
        }
        authorRepository.deleteById(authorId);
    }

    @Transactional
    public void updateAuthor(Long authorId, String authorName) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalStateException(
                        "author with id" + authorId + "does not exist"));

        if (authorName != null && authorName.length() > 0 &&
                !Objects.equals(author.getAuthorName(), authorName)){
            author.setAuthorName(authorName);
        }
    }

}
