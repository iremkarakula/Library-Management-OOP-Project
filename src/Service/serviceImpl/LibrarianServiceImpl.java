package service.serviceImpl;

import entity.Bill;
import entity.BookStatus;
import entity.Library;
import entity.Member;
import service.LibrarianService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class LibrarianServiceImpl implements LibrarianService {

    private final Library library;

    public LibrarianServiceImpl(Library library) {
        this.library = library;
    }

    @Override
    public long applyRentalFee(Member member) {

        Bill bill = new Bill(member, 5, "Kiralama ücreti");

        member.setTotalDebt(member.getTotalDebt()+5);
        member.getBills().add(bill);
        library.getBills().add(bill);

        return bill.getPrice();
    }

    @Override
    public long applyLateReturnFee(Member member, LocalDate returnedDate) {
        int days = (int)ChronoUnit.DAYS.between(returnedDate, LocalDate.now());
        int penalty = 5 * days;
        Bill bill = new Bill(member, penalty, days +" gün geç kaldığı için "+ penalty +" TL ceza");
        member.setTotalDebt(member.getTotalDebt()+penalty);
        member.getBills().add(bill);
        library.getBills().add(bill);

        return bill.getPrice();
    }

    @Override
    public long applyBookDamageFee(Member member) {
        Bill bill = new Bill(member, 20, "Kitaba zarar verildiği için 20 TL ceza");
        member.setTotalDebt(member.getTotalDebt()+20);
        member.getBills().add(bill);
        library.getBills().add(bill);

        return bill.getPrice();
    }

    @Override
    public long applyBookLossFee(Member member) {
        Bill bill = new Bill(member, 50, "Kitap kaybedildiği için 50 TL ceza");
        member.setTotalDebt(member.getTotalDebt()+50);
        member.getBills().add(bill);
        library.getBills().add(bill);

        return bill.getPrice();
    }
}
