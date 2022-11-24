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

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findBookByName(book.getBookName());
        if (bookOptional.isPresent()){
            throw new IllegalStateException("guestName taken");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if (!exists){
            throw new IllegalStateException("book with id" + bookId + "does not exists");
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Long bookId, String bookName) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException(
                        "book with id" + bookId + "does not exist"));

        if (bookName != null && bookName.length() > 0 &&
                !Objects.equals(book.getBookName(), bookName)){
            book.setBookName(bookName);
        }
    }
}
