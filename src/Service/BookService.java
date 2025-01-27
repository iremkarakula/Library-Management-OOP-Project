package service;

import dto.BookDTO;
import entity.Book;
import entity.BookStatus;

import java.util.List;
import java.util.Set;

public interface BookService {

    Set<Book> getBooksByAuthor(long authorId);
    Book getBook(long id);
    Book createBook(BookDTO book, long authorId);
    Book updateBook(long bookId, BookDTO book);
    Boolean deleteBook(long bookId);
    BookStatus updateBookStatus(Book book, BookStatus status);


}
