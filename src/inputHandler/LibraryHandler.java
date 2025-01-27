package inputHandler;

import entity.*;
import service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class LibraryHandler {

    private final Scanner scanner;
    private final LibraryService libraryService;

    public LibraryHandler(Scanner scanner, LibraryService libraryService) {
        this.scanner = scanner;
        this.libraryService = libraryService;
    }

    public void handle() {
        System.out.println("***** Kütüphane İşlemleri *****");
        System.out.println("1. Yazarları Listele");
        System.out.println("2. Kitapları Listele");
        System.out.println("3. Üyeleri Listele");
        System.out.println("4. Ödünç Kitapları Listele");
        System.out.println("5. Ödünç Kitap Geçmişi Listele");
        System.out.println("6. Faturaları Listele");
        System.out.println("7. Faturaları Fiyat Artan Sıraya Göre Listele");
        System.out.println("8. Faturaları Fiyat Azalan Sıraya Göre Listele");
        System.out.println("9. Doğum Tarihine Göre Üyeleri Artan Sırada Listele");
        System.out.println("10. Doğum Tarihine Göre Üyeleri Azalan Sırada Listele");
        System.out.println("11. İlk Adlarına Göre Yazarları Artan Sırada Listele");
        System.out.println("12. İlk Adlarına Göre Yazarları Azalan Sırada Listele");
        System.out.println("13. Kitap Ara");
        System.out.println("14. Kiralamak İçin Uygun Kitapları Listele");
        System.out.println("15. Ana Menü");
        System.out.print("Seçiminizi yapın: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                List<Author> authors = libraryService.getAuthors();
                authors.forEach(author -> System.out.println(author));
                break;

            case 2:
                List<Book> books = libraryService.getBooks();
                books.forEach(book -> System.out.println(book));
                break;

            case 3:
                List<Member> members = libraryService.getMembers();
                members.forEach(member -> System.out.println(member));
                break;

            case 4:
                List<BookLoan> loanBooks = libraryService.getLoanBooks();
                loanBooks.forEach(loan -> System.out.println(loan));
                break;

            case 5:
                List<Book> loanBookHistory = libraryService.getLoanBookHistory();
                loanBookHistory.forEach(book -> System.out.println(book));
                break;

            case 6:
                List<Bill> bills = libraryService.getBills();
                bills.forEach(bill -> System.out.println(bill));
                break;

            case 7:
                List<Bill> billsByPriceAsc = libraryService.getBillsByPriceAsc();
                billsByPriceAsc.forEach(bill -> System.out.println(bill));
                break;

            case 8:
                List<Bill> billsByPriceDesc = libraryService.getBillsByPriceDesc();
                billsByPriceDesc.forEach(bill -> System.out.println(bill));
                break;

            case 9:
                List<Member> membersByBirthAsc = libraryService.getMemberByBirthDateAsc();
                membersByBirthAsc.forEach(member -> System.out.println(member));
                break;

            case 10:
                List<Member> membersByBirthDesc = libraryService.getMemberByBirthDateDesc();
                membersByBirthDesc.forEach(member -> System.out.println(member));
                break;

            case 11:
                List<Author> authorsByFirstnameAsc = libraryService.getAuthorsByFirstnameAsc();
                authorsByFirstnameAsc.forEach(author -> System.out.println(author));
                break;

            case 12:
                List<Author> authorsByFirstnameDesc = libraryService.getAuthorsByFirstnameDesc();
                authorsByFirstnameDesc.forEach(author -> System.out.println(author));
                break;

            case 13:
                System.out.println("Kitap adı girin: ");
                String input = scanner.nextLine();
                List<Book> searchResult = libraryService.searchBook(input);
                searchResult.forEach(book -> System.out.println(book));
                break;

            case 14:
                List<Book> availableBooks = libraryService.findAvailableBooks();
                availableBooks.forEach(book -> System.out.println(book));
                break;
            case 15:
                break;
            default:
                System.out.println("Geçersiz seçim.");
        }
    }

}
