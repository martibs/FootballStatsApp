package no.experis.FootballStats.Admin.Models;

public class News {
    private int news_id;
    private String news_string;
    private int team_id;
    private int player_id;

    public News(){

    }

    public News(int news_id, String news_string, int team_id, int player_id) {
        this.news_id = news_id;
        this.news_string = news_string;
        this.team_id = team_id;
        this.player_id = player_id;
    }

    public int getNews_id() {
        return news_id;
    }

    public String getNews_string() {
        return news_string;
    }

    public int getTeam_id() {
        return team_id;
    }

    public int getPlayer_id() {
        return player_id;
    }
}
