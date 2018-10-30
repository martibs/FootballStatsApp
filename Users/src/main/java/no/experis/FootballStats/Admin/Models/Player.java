package no.experis.FootballStats.Admin.Models;

import java.sql.Date;

public class Player extends Person{

    private String player_id;
    private String normal_position;
    private String number;
    private int team_id;


    public Player(){

    }


    public Player(String person_id, String first_name, String last_name, Date date_of_birth, int address_id) {
        super(person_id, first_name, last_name, date_of_birth, address_id);
    }


    public Player(String person_id, String first_name, String last_name, Date date_of_birth, int address_id, String player_id, String normal_position, String number, int team_id) {
        super(person_id, first_name, last_name, date_of_birth, address_id);
        this.player_id = player_id;
        this.normal_position = normal_position;
        this.number = number;
        this.team_id = team_id;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public String getNormal_position() {
        return normal_position;
    }

    public String getNumber() {
        return number;
    }

    public int getTeam_id() {
        return team_id;
    }
}
