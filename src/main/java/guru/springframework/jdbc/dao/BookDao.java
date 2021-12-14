package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Book;

import java.util.Optional;

public interface BookDao {
    Book getById(Long id);
    Book saveNewBook(Book book);
    Book updateBook(Book book);
    Book getBookByTitle(String title);
    void deleteBookById(Long id);
}
