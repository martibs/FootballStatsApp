package no.experis.FootballStats;

public class Person {
    private int id;
    private String firstname,lastname,dateofbirth;
    private int addressid;

    public Person(int id, String firstname, String lastname, String dateofbirth, int addressid) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.addressid = addressid;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public int getAddressid() {
        return addressid;
    }

    public String toString(){
        return "ID = " + id + ", Firstname = " + firstname + ", Lastname = " + lastname + ", Dateofbirth = " + dateofbirth + ", AddressID = " + addressid;
    }
}
