package no.experis.FootballStats.Admin.Models;

import java.util.ArrayList;

public class Goal {

    private int goal_id;
    private int player_id;
    private int goal_type_id;
    private int match_id;
    private String description;
    private String type;

    public Goal(){

    }

    public Goal(int goal_id, int player_id, int goal_type_id, int match_id, String description, String type) {
        this.goal_id = goal_id;
        this.player_id = player_id;
        this.goal_type_id = goal_type_id;
        this.match_id = match_id;
        this.description = description;
        this.type = type;
    }

    public int getGoal_id() {
        return goal_id;
    }

    public void setGoal_id(int goal_id) {
        this.goal_id = goal_id;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public int getGoal_type_id() {
        return goal_type_id;
    }

    public void setGoal_type_id(int goal_type_id) {
        this.goal_type_id = goal_type_id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
