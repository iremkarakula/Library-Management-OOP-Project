package entity;

import java.time.LocalDate;
import java.util.Set;

public class Author extends Person{

    private Set<Book> books;

    public Author(long id, String firstName, String lastName, LocalDate birthOfDate, Set<Book> books) {
        super(id, firstName, lastName, birthOfDate);
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
