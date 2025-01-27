import entity.Author;
import entity.Library;
import inputHandler.*;
import service.*;
import service.serviceImpl.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        AuthorService authorService = new AuthorServiceImpl(library);
        AuthorHandler authorHandler = new AuthorHandler(scanner, authorService);

        BookService bookService = new BookServiceImpl(authorService, library);
        BookHandler bookHandler = new BookHandler(scanner, bookService);

        LibrarianService librarianService = new LibrarianServiceImpl(library);

        MemberService memberService = new MemberServiceImpl();
        LibrarianHandler librarianHandler = new LibrarianHandler(scanner, librarianService, memberService);
        MemberHandler memberHandler = new MemberHandler(scanner, memberService);
        BookLoanService bookLoanService = new BookLoanServiceImpl(library,librarianService, bookService, memberService);
        BookLoanHandler bookLoanHandler = new BookLoanHandler(scanner, bookLoanService);
        LibraryService libraryService = new LibraryServiceImpl(library);
        LibraryHandler libraryHandler = new LibraryHandler(scanner, libraryService);

        int choice;

        while(true){

            System.out.println("***** Kütüphane Yönetim Sistemi *****");
            System.out.println("1. Yazar İşlemleri");
            System.out.println("2. Kitap İşlemleri");
            System.out.println("3. Kitap Kiralama İşlemleri");
            System.out.println("4. Kütüphane İşlemleri");
            System.out.println("5. Kütüphaneci İşlemleri");
            System.out.println("6. Üye İşlemleri");

            System.out.print("Bir seçenek girin: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    authorHandler.handle();
                    break;
                case 2:
                    bookHandler.handle();
                    break;
                case 3:
                    bookLoanHandler.handle();
                    break;
                case 4:
                    libraryHandler.handle();
                    break;
                case 5:
                    librarianHandler.handle();
                    break;
                case 6:
                    memberHandler.handle();
                    break;
                default:
                  System.out.println("Geçersiz işlem");

            }
        }



    }
}