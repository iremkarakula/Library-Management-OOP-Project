package entity;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Author> authors;
    private List<Book> books;
    private List<Book> loanedBookHistory;
    private List<BookLoan> loanedBooks;
    private List<Member> members;
    private List<Bill> bills;

    public Library() {
        this.authors = new ArrayList<>();
        this.books = new ArrayList<>();
        this.loanedBookHistory = new ArrayList<>();
        this.loanedBooks = new ArrayList<>();
        this.members = new ArrayList<>();
        this.bills = new ArrayList<>();
    }


    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<BookLoan> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(List<BookLoan> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public List<Book> getLoanedBookHistory() {
        return loanedBookHistory;
    }

    public void setLoanedBookHistory(List<Book> loanedBookHistory) {
        this.loanedBookHistory = loanedBookHistory;
    }
}
