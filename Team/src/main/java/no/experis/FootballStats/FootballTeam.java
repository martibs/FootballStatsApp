package no.experis.FootballStats;

public class FootballTeam {

    private String team_id;
    private String association_id;
    private String coach_id;
    private String owner_id;
    private String location_id;
    private String association_name;
    private String association_description;

    public FootballTeam(String team_id, String association_id, String coach_id, String owner_id, String location_id, String association_name, String association_description) {
        this.team_id = team_id;
        this.association_id = association_id;
        this.coach_id = coach_id;
        this.owner_id = owner_id;
        this.location_id = location_id;
        this.association_name = association_name;
        this.association_description = association_description;
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

    public String getAssociation_name() {
        return association_name;
    }

    public String getAssociation_description() {
        return association_description;
    }
}
