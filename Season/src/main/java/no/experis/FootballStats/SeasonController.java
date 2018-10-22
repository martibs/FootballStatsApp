package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SeasonController {

    private SeasonService seasonService = new SeasonService();

    @GetMapping("/showSeasons")
    public List showSeasons() {
        List<Season> seasons = seasonService.displayAllSeasons();
        return seasons;
    }

    @GetMapping("/showOneSeason/{someID}")
    public Season showOneSeason(@PathVariable(value="someID") String id) {
        Season season = seasonService.displayOneSeason(id);
        return season;
    }

}