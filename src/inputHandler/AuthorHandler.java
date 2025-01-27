package inputHandler;

import dto.AuthorDTO;
import entity.Author;
import entity.BookLoan;
import service.AuthorService;

import java.util.Scanner;

public class AuthorHandler {

    private final Scanner scanner;
    private final AuthorService authorService;

    public AuthorHandler(Scanner scanner, AuthorService authorService) {
        this.scanner = scanner;
        this.authorService = authorService;
    }

    public void handle(){

        System.out.println("***** Yazar İşlemleri *****");
        System.out.println("1. Yazar Ekle");
        System.out.println("2. Yazar Güncelle");
        System.out.println("3. Yazar Sil");
        System.out.println("4. Yazar Getir");
        System.out.println("5. Ana Menü");
        System.out.print("Seçiminizi yapın: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1:
                System.out.println("Yazarın adı: ");
                String firstname = scanner.nextLine();

                System.out.println("Yazarın soyadı: ");
                String lastname = scanner.nextLine();

                System.out.println("Yazarın doğum tarihini giriniz (gün-ay-yıl)");
                String date = scanner.nextLine();
                AuthorDTO dto = new AuthorDTO(firstname, lastname, date);

                Author author = authorService.createAuthor(dto);
                System.out.println("Yazar başarıyla eklendi: " + author);
                break;
            case 2:
                System.out.println("Yazar id: ");
                long updateId = scanner.nextLong();

                System.out.println("Yazarın adı: ");
                String updateFirstname = scanner.nextLine();

                System.out.println("Yazarın soyadı: ");
                String updateLastname = scanner.nextLine();

                System.out.println("Yazarın doğum tarihini giriniz (gün-ay-yıl)");
                String updateBirthDate = scanner.nextLine();
                AuthorDTO dto2 = new AuthorDTO(updateFirstname, updateLastname, updateBirthDate);

                Author updateAuthor = authorService.updateAuthor(updateId, dto2);
                System.out.println("Yazar başarıyla güncellendi: " + updateAuthor);
                break;
            case 3:
                System.out.println("Yazar id: ");
                long deleteId = scanner.nextLong();
                Boolean result = authorService.deleteAuthor(deleteId);
                if(result){
                    System.out.println("Yazar başarıyla silindi");
                } else {
                    System.out.println("Yazar silinemedi");
                }
                break;
            case 4:
                System.out.println("Yazar id: ");
                long getId = scanner.nextLong();
                Author author1 = authorService.getAuthor(getId);
                System.out.println(author1);
                break;
            case 5:
                break;
            default:
                System.out.println("Geçersiz seçim");
        }
    }
}
