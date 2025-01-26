package Service;

import entity.Author;
import entity.Book;

import java.util.List;

public interface AuthorService {

    Author getAuthor(long id);
    Author createAuthor(Author author);
    Author updateAuthor(long id, Author author);
    Boolean deleteAuthor(long id);
}
