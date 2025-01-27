package service;

import entity.BookLoan;

public interface BookLoanService {

    BookLoan findBookLoan(long id);
    BookLoan borrowBook(long memberId, long bookId);
    BookLoan returnBook(long memberId, long bookId, String status);


}
