package no.experis.FootballStats;

public class Coach extends Person{

    private String coach_id;

    public Coach(String person_id, String first_name, String last_name, String date_of_birth, String address_id, String coach_id) {
        super(person_id, first_name, last_name, date_of_birth, address_id);
        this.coach_id = coach_id;
    }

    public String getCoach_id() {
        return coach_id;
    }



}
