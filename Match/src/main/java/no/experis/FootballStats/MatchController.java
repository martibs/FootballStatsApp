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

    @GetMapping("/showOneMatch")
    public Match showMatch() {
        String match_id = "1"; // TODO: CHANG TO A CORRECT SPRING BOOT GET VARIABLE!

        Match match = matchService.displayOneMatch(match_id);
        return match;
    }

}