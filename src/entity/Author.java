package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Author extends Person{

    private Set<Book> books;

    public Author(String firstName, String lastName, String birthOfDate) {
        super(firstName, lastName, birthOfDate);
        this.books = new HashSet<>();
    }

    public Author() {
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
