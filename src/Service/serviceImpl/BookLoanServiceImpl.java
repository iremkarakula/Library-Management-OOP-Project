package service.serviceImpl;

import entity.*;
import service.BookLoanService;
import service.BookService;
import service.LibrarianService;
import service.MemberService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;


public class BookLoanServiceImpl implements BookLoanService {
    private final Library library;
    private final LibrarianService librarianService;
    private final BookService bookService;
    private final MemberService memberService;

    public BookLoanServiceImpl(Library library, LibrarianService librarianService, BookService bookService, MemberService memberService) {
        this.library = library;
        this.librarianService = librarianService;
        this.bookService = bookService;
        this.memberService = memberService;
    }

    @Override
    public BookLoan findBookLoan(long id) {
        return library.getLoanedBooks().stream().filter(b->b.getId() == id).findFirst().orElseThrow(()->new NoSuchElementException("Kitap bulunamadı"));
    }

    @Override
    public BookLoan borrowBook(long memberId, long bookId) {

        Member member = memberService.getMember(memberId);
        Book book = bookService.getBook(bookId);

        if(book.getBookStatus() != BookStatus.AVAILABLE){
            throw new IllegalStateException("Kitap kiralanamaz");
        }

        BookLoan bookLoan = new BookLoan(book, member, LoanStatus.ON_LOAN);

        book.setBookStatus(BookStatus.CHECKED_OUT);
        library.getLoanedBookHistory().add(book);
        library.getLoanedBooks().add(bookLoan);
        member.getLoanedBookHistory().add(book);
        member.getLoanedBooks().add(bookLoan);


        librarianService.applyRentalFee(member);

      return bookLoan;
    }

    @Override
    public BookLoan returnBook(long memberId, long bookId, String status) {

        Member member = memberService.getMember(memberId);
        Book book = bookService.getBook(bookId);
        BookLoan bookLoan = findBookLoan(bookId);
        BookStatus bookStatus = BookStatus.valueOf(status.toUpperCase().replace(" ", "_"));

       LocalDate returedDate = bookLoan.getReturnDate();
       LocalDate actualDate = LocalDate.now();

       if(actualDate.isAfter(returedDate)){
           librarianService.applyLateReturnFee(member, returedDate);
       }

       if(bookStatus == BookStatus.LOST){
         librarianService.applyBookLossFee(member);
           book.setBookStatus(BookStatus.LOST);
           bookLoan.setLoanStatus(LoanStatus.LOST);
       } else if(bookStatus == BookStatus.DAMAGED){
            librarianService.applyBookDamageFee(member);
            book.setBookStatus(BookStatus.DAMAGED);
            bookLoan.setLoanStatus(LoanStatus.RETURNED);
        } else {
           book.setBookStatus(BookStatus.AVAILABLE);
           bookLoan.setLoanStatus(LoanStatus.RETURNED);

       }

        member.getLoanedBooks().remove(bookLoan);
        library.getLoanedBooks().remove(bookLoan);
        return bookLoan;
    }
}
