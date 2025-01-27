package inputHandler;

import entity.BookLoan;
import service.BookLoanService;

import java.util.Scanner;

public class BookLoanHandler {

    private final Scanner scanner;
    private final BookLoanService bookLoanService;

    public BookLoanHandler(Scanner scanner, BookLoanService bookLoanService) {
        this.scanner = scanner;
        this.bookLoanService = bookLoanService;
    }

    public void handle() {
        System.out.println("***** Kitap Ödünç İşlemleri *****");
        System.out.println("1. Kitap Ödünç Al");
        System.out.println("2. Kitap İade Et");
        System.out.println("3. Kitap Ödünç Bilgilerini Görüntüle");
        System.out.println("4. Ana Menü");
        System.out.print("Seçiminizi yapın: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:

                System.out.println("Üye ID'sini girin: ");
                long memberIdForBorrow = scanner.nextLong();

                System.out.println("Kitap ID'sini girin: ");
                long bookIdForBorrow = scanner.nextLong();

                BookLoan loan = bookLoanService.borrowBook(memberIdForBorrow, bookIdForBorrow);
                System.out.println("Kitap ödünç alındı: " + loan);
                break;

            case 2:

                System.out.println("Üye ID'sini girin: ");
                long memberIdForReturn = scanner.nextLong();

                System.out.println("Kitap ID'sini girin: ");
                long bookIdForReturn = scanner.nextLong();
                scanner.nextLine();

                System.out.println("Kitap durumu girin (AVAILABLE, CHECKED_OUT, RESERVED, LOST, DAMAGED): ");
                String status = scanner.nextLine();

                BookLoan returnedLoan = bookLoanService.returnBook(memberIdForReturn, bookIdForReturn, status);
                System.out.println("Kitap başarıyla iade edildi: " + returnedLoan);
                break;

            case 3:
                System.out.println("Ödünç alınan kitap ID'sini girin: ");
                long loanId = scanner.nextLong();

                BookLoan bookLoan = bookLoanService.findBookLoan(loanId);
                System.out.println("Ödünç Bilgileri: " + bookLoan);
                break;
            case 4:
                break;
            default:
                System.out.println("Geçersiz seçim!");
        }
    }


}
