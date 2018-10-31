package no.experis.FootballStats.Admin.Models;

import java.sql.Date;

public class Coach extends Person{

    private int coach_id;

    public Coach(){

    }

    public Coach(String person_id, String first_name, String last_name, Date date_of_birth, int address_id, int coach_id) {
        super(person_id, first_name, last_name, date_of_birth, address_id);
        this.coach_id = coach_id;
    }

    public int getCoach_id() {
        return coach_id;
    }

}
