package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MatchController {

    private MatchService matchService = new MatchService();

    @GetMapping("/showMatches")
    public List shotMatches() {
        List<Match> matches = matchService.displayAllMatches();
        return matches;
    }

}