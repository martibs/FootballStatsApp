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

    @GetMapping("/showOneGoal")
    public Goal showOneGoal(){
        String Goalid = "1";      // TODO: Change the var to proper springboot GET variable
        Goal goal = goalService.displayOneGoal(Goalid);
        return goal;
    }

}