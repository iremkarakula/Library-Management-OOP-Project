package service.serviceImpl;

import entity.*;
import service.LibraryService;

import java.util.List;

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
}
