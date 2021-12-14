package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Book;
import guru.springframework.jdbc.repositories.BookRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Component
public class BookDaoImpl implements BookDao {

    private final BookRepository bookRepository;

    public BookDaoImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book saveNewBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    @Override
    public Book updateBook(Book book) {
        Book foundBook = bookRepository.getById(book.getId());
        foundBook.setAuthorId(book.getAuthorId());
        foundBook.setPublisher(book.getPublisher());
        foundBook.setTitle(book.getTitle());
        foundBook.setIsbn(book.getIsbn());

        return bookRepository.save(foundBook);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findBookByTitle(title).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
