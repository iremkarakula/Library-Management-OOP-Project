package Service;

import entity.Author;
import entity.Book;
import entity.BookLoan;
import entity.Member;

import java.util.List;

public interface LibraryService {

    List<Author> getAuthors();
    List<Book> getBooks();
    List<Member> getMembers();
    List<BookLoan> loanBooks();

}
