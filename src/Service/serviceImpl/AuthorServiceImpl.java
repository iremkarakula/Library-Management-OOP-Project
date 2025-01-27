package service.serviceImpl;

import dto.AuthorDTO;
import entity.Author;
import entity.Library;
import service.AuthorService;

import java.util.NoSuchElementException;

public class AuthorServiceImpl implements AuthorService {

    private final Library library;

    public AuthorServiceImpl(Library library) {
        this.library = library;
    }

    @Override
    public Author getAuthor(long id) {

        return library.getAuthors()
                .stream()
                .filter(author -> author.getId() == id)
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("Yazar bulunamadı!"));
    }

    @Override
    public Author createAuthor(AuthorDTO author) {

        Author createdAuthor = new Author(author.firstname(), author.lastname(), author.birthOfDate());
        library.getAuthors().add(createdAuthor);
        return createdAuthor;

    }

    @Override
    public Author updateAuthor(long id, AuthorDTO authorDto) {
        Author author = getAuthor(id);
        author.setFirstName(authorDto.firstname());
        author.setLastName(authorDto.lastname());
        author.setBirthOfDate(authorDto.birthOfDate());
        return author;
    }

    @Override
    public Boolean deleteAuthor(long id) {
        Author author = getAuthor(id);
        library.getBooks().removeIf(b -> b.getAuthor().equals(author));
        library.getAuthors().remove(author);
        return true;
    }
}
