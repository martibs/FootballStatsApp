package no.experis.FootballStats;

import java.util.ArrayList;

public class Team{

    private String team_id;
    private String association_id;
    private String coach_id;
    private String owner_id;
    private String location_id;

    public Team(String team_id, String association_id, String coach_id, String owner_id, String location_id) {
        this.team_id = team_id;
        this.association_id = association_id;
        this.coach_id = coach_id;
        this.owner_id = owner_id;
        this.location_id = location_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public String getAssociation_id() {
        return association_id;
    }

    public String getCoach_id() {
        return coach_id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public String getLocation_id() {
        return location_id;
    }

}
