package service.serviceImpl;

import dto.MemberDTO;
import entity.*;
import service.MemberService;

import java.util.List;
import java.util.NoSuchElementException;

public class MemberServiceImpl implements MemberService {

    private Library library;

    @Override
    public Member getMember(long id) {
        return library.getMembers()
                .stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("Üye bulunamadı"));

    }

    @Override
    public Member createMember(MemberDTO memberDTO) {
        MemberStatus status = MemberStatus.valueOf(memberDTO.status());
        Member member = new Member(memberDTO.firstname(), memberDTO.lastname(), memberDTO.birthOfDate(), status, memberDTO.adress(), memberDTO.phone());
        library.getMembers().add(member);
        return member;
    }

    @Override
    public Member updateMember(long id, MemberDTO memberDTO) {
        Member member = getMember(id);
        MemberStatus status = MemberStatus.valueOf(memberDTO.status());
        member.setFirstName(memberDTO.firstname());
        member.setLastName(memberDTO.lastname());
        member.setBirthOfDate(memberDTO.birthOfDate());
        member.setStatus(status);
        member.setAddress(memberDTO.adress());
        member.setPhone(member.getPhone());
        return member;
    }

    @Override
    public Boolean deleteMember(long id) {
        Member member = getMember(id);
        library.getMembers().remove(member);
        return true;
    }

    @Override
    public List<Book> getLoanedBookHistory(long id) {
        return getMember(id).getLoanedBookHistory();
    }

    @Override
    public List<BookLoan> getLoanedBooks(long id) {
        return getMember(id).getLoanedBooks();
    }
}
