package kz.sensei.crudlab1.service;

import kz.sensei.crudlab1.Model.Book;
import kz.sensei.crudlab1.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiice {
    private final BookRepository bookRepository;


    public BookServiice(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> takeAllBook(){
        return bookRepository.findAll();
    }

    public Optional<Book> findByID(Long id){
        return bookRepository.findById(id);
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public void updateBook(Long id, Book updatedBook){
        Book book = bookRepository.getOne(id);

        book.setAuthor(updatedBook.getAuthor());
        book.setTitle(updatedBook.getTitle());
        book.setPrice(updatedBook.getPrice());

        bookRepository.save(book);
    }

    public List<Book> findByAuthorOrTitle(String title, String author){
        return bookRepository.findByTitleContainingOrAuthorContaining(title, author);
    }

}
