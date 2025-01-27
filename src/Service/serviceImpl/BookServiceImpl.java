package service.serviceImpl;

import dto.BookDTO;
import entity.*;
import service.AuthorService;
import service.BookService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class BookServiceImpl implements BookService {

    private final AuthorService authorService;
    private final Library library;

    public BookServiceImpl(AuthorService authorService, Library library) {
        this.authorService = authorService;
        this.library = library;
    }

    @Override
    public Set<Book> getBooksByAuthor(long authorId) {

        Author author = authorService.getAuthor(authorId);
        if(author == null){
            throw new NoSuchElementException("Yazar bulunamadı");
        }

        return author.getBooks();

    }

    @Override
    public Book getBook(long id) {
        return library.getBooks().stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(()->new NoSuchElementException("Kitap bulunamadı"));

    }

    @Override
    public Book createBook(BookDTO book, long authorId) {

        Author author = authorService.getAuthor(authorId);
        Category category = Category.valueOf(book.category());
        Book created = new Book(author, book.name(), category);
        library.getBooks().add(created);
        author.getBooks().add(created);
        return created;


    }

    @Override
    public Book updateBook(long bookId, BookDTO book) {
        Book foundBook = getBook(bookId);
        Category category = Category.valueOf(book.category());
        foundBook.setCategory(category);
        foundBook.setName(book.name());

        Author newAuthor = authorService.getAuthor(book.author().getId());
        Author oldAuthor = foundBook.getAuthor();

        if(newAuthor != oldAuthor){
            oldAuthor.getBooks().remove(foundBook);
            newAuthor.getBooks().add(foundBook);
            foundBook.setAuthor(newAuthor);
        }

        return foundBook;
    }

    @Override
    public Boolean deleteBook(long bookId) {
        try{
            Book book = getBook(bookId);
            library.getBooks().remove(book);
            book.getAuthor().getBooks().remove(book);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public BookStatus updateBookStatus(long bookId, String status) {
        Book book = getBook(bookId);
        BookStatus bookStatus = BookStatus.valueOf(status.toUpperCase().replace(" ", "_"));
        bookStatus.updateLocalDateTime();
        book.setBookStatus(bookStatus);
        return book.getBookStatus();
    }
}
