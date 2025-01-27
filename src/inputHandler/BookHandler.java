package inputHandler;

import dto.BookDTO;
import entity.Book;
import entity.BookStatus;
import service.BookService;

import java.util.Scanner;
import java.util.Set;

public class BookHandler {

    private final Scanner scanner;
    private final BookService bookService;

    public BookHandler(Scanner scanner, BookService bookService) {
        this.scanner = scanner;
        this.bookService = bookService;
    }

    public void handle(){
        System.out.println("***** Kitap İşlemleri *****");
        System.out.println("1. Kitap Ekle");
        System.out.println("2. Kitap Güncelle");
        System.out.println("3. Kitap Sil");
        System.out.println("4. Kitap Getir");
        System.out.println("5. Yazarın Kitaplarını Getir");
        System.out.println("6. Kitap Durumunu Güncelle");
        System.out.println("7. Ana Menü");
        System.out.print("Seçiminizi yapın: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Kitap adı: ");
                String name = scanner.nextLine();

                System.out.println("Kitap kategorisi: ");
                String category = scanner.nextLine();

                System.out.println("Yazar ID'sini girin: ");
                long authorId = scanner.nextLong();

                BookDTO bookDTO = new BookDTO(name, category);
                Book createdBook = bookService.createBook(bookDTO, authorId);
                System.out.println("Kitap başarıyla eklendi: " + createdBook);
                break;

            case 2:
                System.out.println("Kitap ID'sini girin: ");
                long bookId = scanner.nextLong();
                scanner.nextLine();

                System.out.println("Yeni kitap adı: ");
                String updateName = scanner.nextLine();

                System.out.println("Yeni kitap kategorisi: ");
                String updateCategory = scanner.nextLine();

                System.out.println("Yazar ID!sini girin: ");
                long authorID = scanner.nextLong();

                BookDTO updatedBookDTO = new BookDTO(updateName, updateCategory);
                Book updatedBook = bookService.updateBook(bookId, updatedBookDTO, authorID);
                System.out.println("Kitap başarıyla güncellendi: " + updatedBook);
                break;

            case 3:

                System.out.println("Kitap ID'sini girin: ");
                long deleteBookId = scanner.nextLong();

                Boolean deleteResult = bookService.deleteBook(deleteBookId);
                if (deleteResult) {
                    System.out.println("Kitap başarıyla silindi");
                } else {
                    System.out.println("Kitap silinemedi");
                }
                break;

            case 4:

                System.out.println("Kitap ID'sini girin: ");
                long getBookId = scanner.nextLong();

                Book book = bookService.getBook(getBookId);
                System.out.println(book);
                break;

            case 5:

                System.out.println("Yazar ID'sini girin: ");
                long authorIdToSearch = scanner.nextLong();

                Set<Book> booksByAuthor = bookService.getBooksByAuthor(authorIdToSearch);
                System.out.println("Yazarın kitapları: ");
                booksByAuthor.forEach(b -> System.out.println(b.getName() + ", " + b.getCategory()));
                break;

            case 6:

                System.out.println("Kitap ID'sini girin: ");
                long bookIdToUpdate = scanner.nextLong();
                scanner.nextLine();

                System.out.println("Kitap durumu (AVAILABLE, CHECKED_OUT, RESERVED, LOST, DAMAGED): ");
                String statusInput = scanner.nextLine();
                BookStatus status = BookStatus.valueOf(statusInput.toUpperCase());

                BookStatus bookToUpdateStatus = bookService.updateBookStatus(bookService.getBook(bookIdToUpdate), status);
                System.out.println("Kitap durumu başarıyla güncellendi: " + bookToUpdateStatus);
                break;
            case 7:
                break;

            default:
                System.out.println("Geçersiz seçim");
        }

    }


}
