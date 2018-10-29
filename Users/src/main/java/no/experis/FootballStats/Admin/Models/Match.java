package no.experis.FootballStats.Admin.Models;

public class Match {

    private String match_id;
    private String match_date;
    private String home_team_id;
    private String away_team_id;
    private String season_id;
    private String location_id;

    public Match(String match_id, String match_date, String home_team_id, String away_team_id, String season_id, String location_id) {
        this.match_id = match_id;
        this.match_date = match_date;
        this.home_team_id = home_team_id;
        this.away_team_id = away_team_id;
        this.season_id = season_id;
        this.location_id = location_id;
    }

    public String getMatch_id() {
        return match_id;
    }

    public String getMatch_date() {
        return match_date;
    }

    public String getHome_team_id() {
        return home_team_id;
    }

    public String getAway_team_id() {
        return away_team_id;
    }

    public String getSeason_id() {
        return season_id;
    }

    public String getLocation_id() {
        return location_id;
    }
}

