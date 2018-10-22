package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MatchController {

    private MatchService matchService = new MatchService();

    @GetMapping("/showMatches")
    public List showMatches() {
        List<Match> matches = matchService.displayAllMatches();
        return matches;
    }

    @GetMapping("/showOneMatch/{someID}")
    public Match showMatch(@PathVariable(value="someID") String id) {

        Match match = matchService.displayOneMatch(id);
        return match;
    }
}