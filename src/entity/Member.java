package entity;

import java.time.LocalDate;
import java.util.List;

public class Member extends Person{

    private MemberStatus status;
    private Address address;
    private String phone;
    private List<Book> loanedBookHistory;
    private List<Book> loanedBooks;

    public Member(long id, String firstName, String lastName, LocalDate birthOfDate, MemberStatus status, Address address, String phone, List<Book> loanedBookHistory, List<Book> loanedBooks) {
        super(id, firstName, lastName, birthOfDate);
        this.status = status;
        this.address = address;
        this.phone = phone;
        this.loanedBookHistory = loanedBookHistory;
        this.loanedBooks = loanedBooks;
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
        this.phone = phone;
    }

    public List<Book> getLoanedBookHistory() {
        return loanedBookHistory;
    }

    public void setLoanedBookHistory(List<Book> loanedBookHistory) {
        this.loanedBookHistory = loanedBookHistory;
    }

    public List<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(List<Book> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }
}
