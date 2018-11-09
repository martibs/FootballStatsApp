package no.experis.FootballStats;

import no.experis.FootballStats.Models.Goal;
import no.experis.FootballStats.Models.GoalType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class GoalController {

    private GoalService goalService = new GoalService();

    @GetMapping("/showGoals")
    public List showGoals() {
        return goalService.displayAllGoals();
    }

    @GetMapping("/showOneGoal/{someID}")
    public Goal showOneGoal(@PathVariable(value="someID") String id){
        return goalService.displayOneGoal(id);
    }


    @GetMapping("/showGoalTypes")
    public List showGoalTypes() {
        return goalService.displayAllGoalTypes();
    }

    @GetMapping("/showGoalTypes/{someID}")
    public GoalType showOneGoalType(@PathVariable(value="someID") String id){
        return goalService.displayOneGoalType(id);
    }

    @GetMapping("/showGoalsInOneMacth/{someID}")
    public List<Goal> showGoalsInMatch(@PathVariable(value="someID") Integer id){
        return goalService.displayAllGoalsInMatch(id);
    }

    @GetMapping("/showGoalsForPlayer/{someID}")
    public List<Goal> showGoalsForPlayer(@PathVariable(value="someID") Integer id){
        return goalService.displayAllGoalsForPlayer(id);
    }

}