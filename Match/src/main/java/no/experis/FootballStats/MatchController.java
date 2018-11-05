package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MatchController {

    private MatchService matchService = new MatchService();

    @GetMapping("/showMatches")
    public List showMatches() {
        return matchService.displayAllMatches();
    }

    @GetMapping("/showUpcommingMatches")
    public List showUpcommingMatches() { return matchService.displayUpcommingMatches();}

    @GetMapping("/showOneMatch/{someID}")
    public Match showMatch(@PathVariable(value="someID") String id) {
        return matchService.displayOneMatch(id);
    }
}