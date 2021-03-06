package no.experis.FootballStats;

import java.util.ArrayList;

public class Person {
    private String person_id;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String address_id;


    public Person(String person_id, String first_name, String last_name, String date_of_birth, String address_id) {
        this.person_id = person_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.address_id = address_id;
    }

    public String getPerson_id() {
        return person_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getAddress_id() {
        return address_id;
    }

    @Override
    public String toString(){
        return "ID = " + person_id + ", Firstname = " + first_name + ", Lastname = " + last_name + ", Dateofbirth = " + date_of_birth + ", AddressID = " + address_id;
    }


}
