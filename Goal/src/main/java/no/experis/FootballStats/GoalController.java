package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class GoalController {

    private GoalService goalService = new GoalService();

    @GetMapping("/showGoals")
    public List showGoals() {
        List<Goal> goals = goalService.displayAllGoals();
        return goals;
    }

    @GetMapping("/showOneGoal/{someID}")
    public Goal showOneGoal(@PathVariable(value="someID") String id){
        Goal goal = goalService.displayOneGoal(id);
        return goal;
    }
}