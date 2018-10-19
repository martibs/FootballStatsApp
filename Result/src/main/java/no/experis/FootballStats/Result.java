package no.experis.FootballStats;

public class Result {

    private String match_id;
    private String team_id;
    private String score;
    private String result;

    public Result(String match_id, String team_id, String score, String result) {
        this.match_id = match_id;
        this.team_id = team_id;
        this.score = score;
        this.result = result;
    }

    public String getMatch_id() {
        return match_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public String getScore() {
        return score;
    }

    public String getResult() {
        return result;
    }
}
