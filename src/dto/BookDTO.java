package dto;

import entity.Author;

public record BookDTO(Author author, String name, String category) {
}
