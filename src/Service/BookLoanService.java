package Service;

import entity.BookLoan;

public interface BookLoanService {

    BookLoan borrowBook(long memberId, long bookId);

    BookLoan returnBook(long memberId, long bookId);

}
