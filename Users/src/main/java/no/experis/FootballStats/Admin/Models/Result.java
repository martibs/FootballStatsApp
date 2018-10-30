package no.experis.FootballStats.Admin.Models;

public class Result {

    private int match_id;
    private int team_id;
    private int score;
    private String result;

    public Result(){

    }

    public Result(int match_id, int team_id, int score, String result) {
        this.match_id = match_id;
        this.team_id = team_id;
        this.score = score;
        this.result = result;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

