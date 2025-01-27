package service.serviceImpl;

import entity.*;
import service.LibraryService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryServiceImpl implements LibraryService {

    private final Library library;

    public LibraryServiceImpl(Library library) {
        this.library = library;
    }

    @Override
    public List<Author> getAuthors() {
        return library.getAuthors();
    }

    @Override
    public List<Book> getBooks() {
        return library.getBooks();
    }

    @Override
    public List<Member> getMembers() {
        return library.getMembers();
    }

    @Override
    public List<BookLoan> getLoanBooks() {
        return library.getLoanedBooks();
    }

    @Override
    public List<Book> getLoanBookHistory() {
        return library.getLoanedBookHistory();
    }

    @Override
    public List<Bill> getBills() {
        return library.getBills();
    }

    @Override
    public List<Bill> getBillsByPriceAsc() {
        List<Bill> sortedList = new ArrayList<>(library.getBills());
        sortedList.sort((b1, b2) -> b1.getPrice() - b2.getPrice());
        return sortedList;
    }

    @Override
    public List<Bill> getBillsByPriceDesc() {
        List<Bill> sortedList = new ArrayList<>(library.getBills());
        sortedList.sort((b1, b2) -> b2.getPrice() - b1.getPrice());
         return sortedList;
    }

    @Override
    public List<Member> getMemberByBirthDateAsc() {
        List<Member> list = new ArrayList<>(library.getMembers());
        list.sort((m1, m2) -> m1.getBirthOfDate().compareTo(m2.getBirthOfDate()));
        return list;
    }

    @Override
    public List<Member> getMemberByBirthDateDesc() {
        List<Member> list = new ArrayList<>(library.getMembers());
        list.sort((m1, m2) -> m2.getBirthOfDate().compareTo(m1.getBirthOfDate()));
        return list;
    }

    @Override
    public List<Author> getAuthorsByFirstnameAsc() {
        List<Author> list = new ArrayList<>(library.getAuthors());
        list.sort((a1, a2)-> a1.getFirstName().compareTo(a2.getFirstName()));
        return list;
    }

    @Override
    public List<Author> getAuthorsByFirstnameDesc() {
        List<Author> list = new ArrayList<>(library.getAuthors());
        list.sort((a1, a2)-> a2.getFirstName().compareTo(a1.getFirstName()));
        return list;
    }

    @Override
    public List<Book> searchBook(String input) {
        return library.getBooks()
                .stream()
                .filter(book -> book.getName().toLowerCase().contains(input.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAvailableBooks() {
        return library.getBooks()
                .stream()
                .filter(book -> book.getBookStatus() == BookStatus.AVAILABLE)
                .collect(Collectors.toList());
    }
}
