package entity;

import java.util.List;

public class Library {

    List<Author> authors;
    List<Book> books;
    List<BookLoan> loanedBooks;
    List<Member> members;

    public Library(List<Author> authors, List<Book> books, List<BookLoan> loanedBooks, List<Member> members) {
        this.authors = authors;
        this.books = books;
        this.loanedBooks = loanedBooks;
        this.members = members;
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
}
