package dto;

import entity.Address;

public record MemberDTO(String firstname, String lastname, String status, String birthOfDate, String phone, Address adress) {
}
