package service;

import dto.MemberDTO;
import entity.Book;
import entity.BookLoan;
import entity.Member;

import java.util.List;

public interface MemberService {

    Member getMember(long id);
    Member createMember(MemberDTO memberDTO);
    Member updateMember(long id, MemberDTO memberDTO);
    Boolean deleteMember(long id);
    List<Book> getLoanedBookHistory(long id);
    List<BookLoan> getLoanedBooks(long id);


}
