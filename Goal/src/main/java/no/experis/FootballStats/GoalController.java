package no.experis.FootballStats;

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
}