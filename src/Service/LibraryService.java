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
    List<Bill> getBillsByPriceAsc();
    List<Bill> getBillsByPriceDesc();
    List<Member> getMemberByBirthDateAsc();
    List<Member> getMemberByBirthDateDesc();
    List<Author> getAuthorsByFirstnameAsc();
    List<Author> getAuthorsByFirstnameDesc();
    List<Book> searchBook(String input);
    List<Book> findAvailableBooks();

}

