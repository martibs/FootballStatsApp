package no.experis.FootballStats;

import java.util.ArrayList;

public class Player extends Person{

    private String player_id;
    private String normal_position;
    private String number;
    private String team_id;
    private String player_image;


    public Player(String person_id, String first_name, String last_name, String date_of_birth, String address_id, String player_id, String normal_position, String number, String team_id, String player_image) {
        super(person_id, first_name, last_name, date_of_birth, address_id);
        this.player_id = player_id;
        this.normal_position = normal_position;
        this.number = number;
        this.team_id = team_id;
        this.player_image = player_image;
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

    public String getTeam_id() {
        return team_id;
    }

    public String getPlayer_image() {
        return player_image;
    }
}
