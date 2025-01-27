package entity;

import util.ValidatePhone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member extends Person{

    private MemberStatus status;
    private Address address;
    private String phone;
    private List<Book> loanedBookHistory;
    private List<BookLoan> loanedBooks;
    private int totalDebt;
    private List<Bill> bills;



    public Member(String firstName, String lastName, String birthOfDate, MemberStatus status, Address address, String phone) {
        super( firstName, lastName, birthOfDate);
        this.status = status;
        this.address = address;
        this.phone = phone;
        this.loanedBookHistory = new ArrayList<>();
        this.loanedBooks = new ArrayList<>();
        this.totalDebt = 0;
        this.bills = new ArrayList<>();

        if(!ValidatePhone.isValidPhoneNumber(phone)){
            throw new IllegalArgumentException("Telefon numarası geçersiz");
        }
    }

    public MemberStatus getStatus() {
        return status;
    }

    public void setStatus(MemberStatus status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {

        if(!ValidatePhone.isValidPhoneNumber(phone)){
            throw new IllegalArgumentException("Telefon numarası geçersiz");
        }

        this.phone = phone;
    }

    public List<Book> getLoanedBookHistory() {
        return loanedBookHistory;
    }

    public void setLoanedBookHistory(List<Book> loanedBookHistory) {
        this.loanedBookHistory = loanedBookHistory;
    }

    public List<BookLoan> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(List<BookLoan> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

    public int getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(int totalDebt) {
        this.totalDebt = totalDebt;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
