package service;

import entity.BookStatus;
import entity.Member;

import java.time.LocalDate;


public interface LibrarianService {

    long applyRentalFee(Member member);
    long applyLateReturnFee(Member member, LocalDate returnedDate);
    long applyBookDamageFee(Member member);
    long applyBookLossFee(Member member);

}
