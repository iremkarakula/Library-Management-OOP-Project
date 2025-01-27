package entity;

import java.time.LocalDate;

public class BookLoan extends Identifiable {

    private Book book;
    private Member member;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private LoanStatus loanStatus;

    public BookLoan(Book book, Member member, LoanStatus loanStatus) {
        super();
        this.book = book;
        this.loanDate = LocalDate.now();
        this.member = member;
        this.returnDate = this.loanDate.plusDays(15);
        this.loanStatus = loanStatus;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }
}
