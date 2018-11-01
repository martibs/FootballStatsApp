package no.experis.FootballStats.Models;

public class GoalType {

    private String goal_type_id;
    private String type;

    public GoalType(String goal_type_id, String type) {
        this.goal_type_id = goal_type_id;
        this.type = type;
    }

    public String getGoal_type_id() {
        return goal_type_id;
    }

    public void setGoal_type_id(String goal_type_id) {
        this.goal_type_id = goal_type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
