package entity;

public class Book extends Identifiable{

    private String name;
    private Author author;
    private BookStatus bookStatus;
    private Category category;
    private Location location;
    private Member currentHolder;

    public Book(long id, Author author, BookStatus bookStatus, String name, Location location, Category category) {
        super(id);
        this.author = author;
        this.bookStatus = bookStatus;
        this.name = name;
        this.location = location;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Member getCurrentHolder() {
        return currentHolder;
    }

    public void setCurrentHolder(Member currentHolder) {
        this.currentHolder = currentHolder;
    }
}
