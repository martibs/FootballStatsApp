package no.experis.FootballStats.Admin.Models;

import java.sql.Date;

public class Owner extends Person{

    private int owner_id;

    public Owner(){

    }

    public Owner(String person_id, String first_name, String last_name, Date date_of_birth, int address_id, int owner_id) {
        super(person_id, first_name, last_name, date_of_birth, address_id);
        this.owner_id = owner_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

}

