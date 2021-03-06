package no.experis.FootballStats.Admin.Models;

public class Team{

    private int team_id;
    private int association_id;
    private int coach_id;
    private int owner_id;
    private int location_id;
    private String team_image;

    public Team(){

    }

    public Team(int team_id, int association_id, int coach_id, int owner_id, int location_id) {
        this.team_id = team_id;
        this.association_id = association_id;
        this.coach_id = coach_id;
        this.owner_id = owner_id;
        this.location_id = location_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public int getAssociation_id() {
        return association_id;
    }

    public void setAssociation_id(int association_id) {
        this.association_id = association_id;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getTeam_image() {return team_image;}

}
