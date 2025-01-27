package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person extends Identifiable{

    private String firstName;
    private String lastName;
    private LocalDate birthOfDate;


    public Person( String firstName, String lastName, String birthOfDateString) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.birthOfDate = LocalDate.parse(birthOfDateString, formatter);
    }

    public Person() {
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

    public void setBirthOfDate(String birthOfDateString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.birthOfDate = LocalDate.parse(birthOfDateString, formatter);
    }
}
