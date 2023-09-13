package kz.sensei.crudlab1.Repository;

import kz.sensei.crudlab1.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByPriceBetween(double minPrice, double maxPrice);
    List<Book> findByTitleContainingOrAuthorContaining(String title, String author);
}
