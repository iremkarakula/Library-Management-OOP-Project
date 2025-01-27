package service;

import dto.AuthorDTO;
import entity.Author;

public interface AuthorService {

    Author getAuthor(long id);
    Author createAuthor(AuthorDTO author);
    Author updateAuthor(long id, AuthorDTO author);
    Boolean deleteAuthor(long id);
}
