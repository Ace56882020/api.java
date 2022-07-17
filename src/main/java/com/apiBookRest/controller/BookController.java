package com.apiBookRest.controller;

import com.apiBookRest.entity.Book;
import com.apiBookRest.repo.BookRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACE
 */
@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookRepo bookrepo;

    @GetMapping("/Book")
    public ResponseEntity<List<Book>> getAllTutorials(@RequestParam(required = false) String nameBook) {
        try {
            List<Book> books = new ArrayList<Book>();

            if (nameBook == null) {
                bookrepo.findAll().forEach(books::add);
            }

            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Book/{id}")
    public ResponseEntity<Book> getTutorialById(@PathVariable("id") Integer id) {
        Optional<Book> tutorialData = bookrepo.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Book")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        try {
            Book _book = bookrepo.save(book);
            return new ResponseEntity<>(_book, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/Book")
    public ResponseEntity<Book> updateTutorial(@RequestBody Book book) {
        Optional<Book> bookData = bookrepo.findById(book.getId());

        if (bookData.isPresent()) {
            Book _book = bookData.get();
            _book.setNameBook(book.getNameBook());
            _book.setDescriptionbook(book.getDescriptionbook());
            _book.setAuthorbook(book.getAuthorbook());
            _book.setNumberCopies(book.getNumberCopies());
            _book.setCost(book.getCost());
            _book.setPublicationDate(book.getPublicationDate());
            return new ResponseEntity<>(bookrepo.save(_book), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Book/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") Integer id) {
        try {
            bookrepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
