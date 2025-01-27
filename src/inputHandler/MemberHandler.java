package inputHandler;

import dto.MemberDTO;
import entity.Address;
import entity.Book;
import entity.BookLoan;
import entity.Member;
import service.MemberService;

import java.util.List;
import java.util.Scanner;

public class MemberHandler {

    private final Scanner scanner;
    private final MemberService memberService;

    public MemberHandler(Scanner scanner, MemberService memberService) {
        this.scanner = scanner;
        this.memberService = memberService;
    }

    public void handle(){

        System.out.println("***** Üye İşlemleri *****");
        System.out.println("1. Üye Ekle");
        System.out.println("2. Üye Güncelle");
        System.out.println("3. Üye Sil");
        System.out.println("4. Üye Bilgilerini Getir");
        System.out.println("5. Üyenin Kitap Ödünç Geçmişini Gör");
        System.out.println("6. Üyenin Ödünç Aldığı Kitapları Gör");
        System.out.println("7. Ana Menü");
        System.out.print("Seçiminizi yapın: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("****Üye Bilgileri***");

                System.out.println("Ad: ");
                String firstnameCreate = scanner.nextLine();

                System.out.println("Soyad: ");
                String lastnameCreate = scanner.nextLine();

                System.out.println("Üyelik Durumu: (STUDENT, EMPLOYEE, ADULT_NON_WORKING, SENIOR) ");
                String statusCreate = scanner.nextLine();

                System.out.println("Doğum Tarihi (gün-ay-yıl): ");
                String birthCreate = scanner.nextLine();

                System.out.println("Telefon numarası: ");
                String phoneCreate = scanner.nextLine();

                System.out.println("****Adres Bilgileri***");

                System.out.println("Şehir: ");
                String cityCreate = scanner.nextLine();

                System.out.println("Sokak: ");
                String streetCreate = scanner.nextLine();

                System.out.println("Bina No: ");
                int buildingCreate = scanner.nextInt();
                Address address = new Address(cityCreate, streetCreate, buildingCreate);
                MemberDTO created = new MemberDTO(firstnameCreate, lastnameCreate, statusCreate, birthCreate, phoneCreate, address);
                Member createdMember = memberService.createMember(created);
                System.out.println("Üye Başarıyla Oluşturuldu: " + createdMember);
                break;
            case 2:

                System.out.println("****Üye Güncelleme Bilgileri***");
                System.out.println("Üye ID'sini girin: ");
                long memberIdUpdate = scanner.nextLong();

                System.out.println("Ad: ");
                String firstnameUpdate = scanner.nextLine();

                System.out.println("Soyad: ");
                String lastnameUpdate = scanner.nextLine();

                System.out.println("Üyelik Durumu: (STUDENT, EMPLOYEE, ADULT_NON_WORKING, SENIOR) ");
                String statusUpdate = scanner.nextLine();

                System.out.println("Doğum Tarihi (gün-ay-yıl): ");
                String birthUpdate = scanner.nextLine();

                System.out.println("Telefon numarası: ");
                String phoneUpdate = scanner.nextLine();

                System.out.println("****Adres Bilgileri***");

                System.out.println("Şehir: ");
                String cityUpdate = scanner.nextLine();

                System.out.println("Sokak: ");
                String streetUpdate = scanner.nextLine();

                System.out.println("Bina No: ");
                int buildingUpdate = scanner.nextInt();
                Address addressUpdate = new Address(cityUpdate, streetUpdate, buildingUpdate);
                MemberDTO updated = new MemberDTO(firstnameUpdate, lastnameUpdate, statusUpdate, birthUpdate, phoneUpdate, addressUpdate);
                Member updatedMember = memberService.updateMember(memberIdUpdate, updated);
                System.out.println("Üye Başarıyla Oluşturuldu: " + updatedMember);
                break;
            case 3:
                System.out.println("Üye ID'sini girin: ");
                long memberIdDelete = scanner.nextLong();

                Boolean result = memberService.deleteMember(memberIdDelete);
                System.out.println(result ? "Üye başarıyla silindi" : "Üye silinemedi");
                break;
            case 4:
                System.out.println("Üye ID'sini girin: ");
                long memberIdGet = scanner.nextLong();
                Member member = memberService.getMember(memberIdGet);
                System.out.println("Üye bilgileri: " + member);
                break;
            case 5:
                System.out.println("Üye ID'sini girin: ");
                long memberId = scanner.nextLong();
                List<Book> bookList = memberService.getLoanedBookHistory(memberId);
                System.out.println("Üyenin Kitap Ödünç Geçmişi: " + bookList);
                break;
            case 6:
                System.out.println("Üye ID'sini girin: ");
                long memberId2 = scanner.nextLong();
                List<BookLoan> bookLoanList = memberService.getLoanedBooks(memberId2);
                System.out.println("Üyenin Ödünç Aldığı Kitaplar: " + bookLoanList);
                break;
            case 7:
                break;

            default:
                System.out.println("Geçersiz seçim, lütfen geçerli bir seçenek girin.");
        }
    }
}
