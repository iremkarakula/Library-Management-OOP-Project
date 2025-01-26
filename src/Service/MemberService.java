package Service;

import entity.Book;
import entity.BookLoan;
import entity.Member;

import java.util.List;

public interface MemberService {

    Member getMember(long id);

    Member createMember(Member member);

    Member updateMember(long id, Member member);

    Boolean deleteMember(long id);

    List<Book> getLoanedBookHistory();

    List<BookLoan> getLoanedBooks();
}
