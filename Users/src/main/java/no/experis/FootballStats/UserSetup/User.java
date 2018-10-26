package no.experis.FootballStats.UserSetup;

import java.util.ArrayList;

public class User {
    private String userId;
    private String email;
    private String password;
    private ArrayList<String> player_watchlist;
    private ArrayList<String> team_watchlist;


    public User(String userId, String email, String password, ArrayList<String> player_watchlist, ArrayList<String> team_watchlist) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.player_watchlist = player_watchlist;
        this.team_watchlist = team_watchlist;
    }


    // GETTERS
    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getPlayer_watchlist() {
        return player_watchlist;
    }

    public ArrayList<String> getTeam_watchlist() {
        return team_watchlist;
    }

    // SETTERS
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPlayer_watchlist(ArrayList<String> player_watchlist) {
        this.player_watchlist = player_watchlist;
    }

    public void setTeam_watchlist(ArrayList<String> team_watchlist) {
        this.team_watchlist = team_watchlist;
    }
}
