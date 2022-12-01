package com.example.librarymanagement.service;

import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findBookByName(book.getBookName());
        if (bookOptional.isPresent()) {
            throw new IllegalStateException("bookName taken");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if (!exists) {
            throw new IllegalStateException("book with id" + bookId + "does not exists");
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Long bookId, String bookName, String isbn, String serialName, String description) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException(
                        "book with id" + bookId + " does not exist"));

        if (bookName != null && bookName.length() > 0 &&
                !Objects.equals(book.getBookName(), bookName)) {
            book.setBookName(bookName);
        }
        if (isbn != null &&
                isbn.length() > 0 &&
                !Objects.equals(book.getIsbn(), isbn)) {
            Optional<Book> bookOptional = bookRepository
                    .findBookByIsbn(isbn);
            if (bookOptional.isPresent()) {
                throw new IllegalStateException("isbn taken");
            }
            book.setIsbn(isbn);
        }
        if (serialName != null &&
                serialName.length() > 0 &&
                !Objects.equals(book.getSerialName(), serialName)) {
            Optional<Book> bookOptional = bookRepository
                    .findBookBySerialName(serialName);
            if (bookOptional.isPresent()) {
                throw new IllegalStateException("serial_name taken");
            }
            book.setSerialName(serialName);
        }
        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(book.getDescription(), description)) {
            Optional<Book> bookOptional = bookRepository
                    .findBookByDescription(description);
            if (bookOptional.isPresent()) {
                throw new IllegalStateException("description taken");
            }
            book.setDescription(description);
        }
    }
}
