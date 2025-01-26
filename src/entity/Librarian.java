package entity;

import java.time.LocalDate;

public class Librarian extends Person{

    private Address address;
    private String phone;

    public Librarian(long id, String firstName, String lastName, LocalDate birthOfDate, Address address, String phone) {
        super(id, firstName, lastName, birthOfDate);
        this.address = address;
        this.phone = phone;
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
}
