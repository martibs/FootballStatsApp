package no.experis.FootballStats;

public class Owner extends Person{

    private String owner_id;

    public Owner(String person_id, String first_name, String last_name, String date_of_birth, String address_id, String owner_id) {
        super(person_id, first_name, last_name, date_of_birth, address_id);
        this.owner_id = owner_id;
    }

    public String getOwner_id() {
        return owner_id;
    }

}
