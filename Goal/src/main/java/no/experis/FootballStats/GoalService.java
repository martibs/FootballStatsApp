package no.experis.FootballStats;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalService {

    private DatabaseManager dbManager = new DatabaseManager();

    // Teams
    public List<Goal> displayAllGoals() {
        ArrayList<Goal> goals = new ArrayList<Goal>();

        goals.addAll(dbManager.getGoals());

        return goals;
    }


    public Goal displayOneGoal(String player_id) {
        ArrayList<Goal> goals = new ArrayList<Goal>();
        goals.addAll(dbManager.getGoals());

        for (Goal goal : goals) {
            if (goal.getGoal_id().equals(player_id)) {
                return goal;
            }
        }
        return null;
    }
}