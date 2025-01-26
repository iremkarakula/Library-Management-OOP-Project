package Service;

import entity.Bill;
import entity.Book;
import entity.BookStatus;

import java.util.List;
import java.util.Optional;

public interface LibrarianService {

    int calculateFine(Optional<BookStatus> bookStatus, Optional<Integer> day);

    Bill createBill(Bill bill);

    List<Book> searchBook();

}
