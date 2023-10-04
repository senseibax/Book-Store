package kz.sensei.crudlab1.Controller;

import kz.sensei.crudlab1.Model.Book;
import kz.sensei.crudlab1.service.BookServiice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    private final BookServiice bookServiice;

    public BookController(BookServiice bookServiice) {
        this.bookServiice = bookServiice;
    }

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookServiice.takeAllBook();
    }

    @PostMapping("/")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookServiice.createBook(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookServiice.findByID(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        bookServiice.updateBook(id, updatedBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookServiice.deleteBook(id);
    }


    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String keyword) {
        return bookServiice.findByAuthorOrTitle(keyword, keyword);
    }
}
