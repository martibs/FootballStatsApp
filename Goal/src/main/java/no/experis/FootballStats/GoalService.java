package no.experis.FootballStats;

import no.experis.FootballStats.Models.Goal;
import no.experis.FootballStats.Models.GoalType;
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


    public Goal displayOneGoal(String goal_id) {
        ArrayList<Goal> goals = new ArrayList<Goal>();
        goals.addAll(dbManager.getGoals());

        for (Goal goal : goals) {
            if (goal.getGoal_id().equals(goal_id)) {
                return goal;
            }
        }
        return null;
    }

    public List<GoalType> displayAllGoalTypes() {
        ArrayList<GoalType> goalTypes = new ArrayList<GoalType>();

        goalTypes.addAll(dbManager.getGoalType());

        return goalTypes;
    }


    public GoalType displayOneGoalType(String goal_type_id) {
        ArrayList<GoalType> goalTypes = new ArrayList<GoalType>();
        goalTypes.addAll(dbManager.getGoalType());

        for (GoalType goalType : goalTypes) {
            if (goalType.getGoal_type_id().equals(goal_type_id)) {
                return goalType;
            }
        }
        return null;
    }

    public List<Goal> displayAllGoalsInMatch(int match_id) {
        ArrayList<Goal> goal = new ArrayList<Goal>();

        goal.addAll(dbManager.getGoalsInOneMatch(match_id));

        return goal;
    }

    public List<Goal> displayAllGoalsForPlayer(int player_id) {
        ArrayList<Goal> goal = new ArrayList<Goal>();

        goal.addAll(dbManager.getGoalsForPlayer(player_id));

        return goal;
    }
}