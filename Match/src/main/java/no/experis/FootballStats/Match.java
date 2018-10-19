package no.experis.FootballStats;

public class Match {

    private String match_id;

    public Match(String match_id, String match_date,  String home_team_id, String away_team_id, String season_id, String location_id) {
        this.match_id = match_id;
    }

    public String getMatch_id() {
        return match_id;
    }

}
