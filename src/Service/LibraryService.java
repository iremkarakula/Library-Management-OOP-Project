package service;

import entity.*;

import java.util.List;

public interface LibraryService {

    List<Author> getAuthors();
    List<Book> getBooks();
    List<Member> getMembers();
    List<BookLoan> getLoanBooks();
    List<Book> getLoanBookHistory();
    List<Bill> getBills();

}
