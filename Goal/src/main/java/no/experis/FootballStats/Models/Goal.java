package no.experis.FootballStats.Models;

import java.util.ArrayList;

public class Goal {

    private String goal_id;
    private String player_id;
    private String goal_type_id;
    private String match_id;
    private String description;




    public Goal(String goal_id, String player_id, String goal_type_id, String match_id, String description) {
        this.goal_id = goal_id;
        this.player_id = player_id;
        this.goal_type_id = goal_type_id;
        this.match_id = match_id;
        this.description = description;
    }

    public String getGoal_id() {
        return goal_id;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public String getGoal_type_id() {
        return goal_type_id;
    }

    public String getMatch_id() {
        return match_id;
    }

    public String getDescription() {
        return description;
    }

}
