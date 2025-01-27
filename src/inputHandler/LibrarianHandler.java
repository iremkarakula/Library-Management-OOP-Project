package inputHandler;

import entity.Member;
import service.LibrarianService;
import service.MemberService;

import java.time.LocalDate;
import java.util.Scanner;

public class LibrarianHandler {

    private final Scanner scanner;
    private final LibrarianService librarianService;
    private final MemberService memberService;

    public LibrarianHandler(Scanner scanner, LibrarianService librarianService, MemberService memberService) {
        this.scanner = scanner;
        this.librarianService = librarianService;
        this.memberService = memberService;
    }

    public void handle() {
        System.out.println("***** Ücret Hesaplama İşlemleri *****");
        System.out.println("1. Kitap Ödünç Ücreti Hesapla");
        System.out.println("2. Geç Teslim Ücreti Hesapla");
        System.out.println("3. Kitap Hasarı Ücreti Hesapla");
        System.out.println("4. Kitap Kaybı Ücreti Hesapla");
        System.out.println("5. Ana Menü");
        System.out.print("Seçiminizi yapın: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Üye ID'sini girin: ");
                long memberId = scanner.nextLong();
                scanner.nextLine();

                Member member = memberService.getMember(memberId);
                long rentalFee = librarianService.applyRentalFee(member);
                System.out.println("Kitap ödünç ücreti: " + rentalFee);
                break;

            case 2:
                System.out.println("Üye ID'sini girin: ");
                long memberIdLate = scanner.nextLong();
                scanner.nextLine();

                Member memberLate = memberService.getMember(memberIdLate);

                System.out.println("Kitap teslim tarihini girin (gün-ay-yıl): ");

                String returnedDateStr = scanner.nextLine();
                LocalDate returnedDate = LocalDate.parse(returnedDateStr);

                long lateReturnFee = librarianService.applyLateReturnFee(memberLate, returnedDate);
                System.out.println("Geç teslim ücreti: " + lateReturnFee);
                break;

            case 3:
                System.out.println("Üye ID'sini girin: ");
                long memberIdDamage = scanner.nextLong();
                scanner.nextLine();

                Member memberDamage = memberService.getMember(memberIdDamage);
                long damageFee = librarianService.applyBookDamageFee(memberDamage);
                System.out.println("Kitap hasar ücreti: " + damageFee);
                break;

            case 4:
                System.out.println("Üye ID'sini girin: ");
                long memberIdLoss = scanner.nextLong();
                scanner.nextLine();

                Member memberLoss = memberService.getMember(memberIdLoss);
                long lossFee = librarianService.applyBookLossFee(memberLoss);
                System.out.println("Kitap kaybı ücreti: " + lossFee);
                break;
            case 5:
                break;
            default:
                System.out.println("Geçersiz seçim");
        }
    }



}
