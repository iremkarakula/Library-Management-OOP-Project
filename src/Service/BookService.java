package Service;

import entity.Author;
import entity.Book;
import entity.BookStatus;

import java.util.List;

public interface BookService {

    List<Book> getBooksByAuthor(long authorId);
    Book createBook(Book book);
    Book updateBook(long bookId, Book book);
    Book deleteBook(long bookId);
    Boolean updateBookStatus(long bookId, BookStatus bookStatus);


}
