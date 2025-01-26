package entity;

import java.time.LocalDate;

public abstract class Person extends Identifiable{

    private String firstName;
    private String lastName;
    private LocalDate birthOfDate;


    public Person(long id, String firstName, String lastName, LocalDate birthOfDate) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthOfDate = birthOfDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(LocalDate birthOfDate) {
        this.birthOfDate = birthOfDate;
    }
}
