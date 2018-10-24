package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SeasonController {

    private SeasonService seasonService = new SeasonService();

    @GetMapping("/showSeasons")
    public List showSeasons() {
        return seasonService.displayAllSeasons();
    }

    @GetMapping("/showOneSeason/{someID}")
    public Season showOneSeason(@PathVariable(value="someID") String id) {
        return seasonService.displayOneSeason(id);
    }

}