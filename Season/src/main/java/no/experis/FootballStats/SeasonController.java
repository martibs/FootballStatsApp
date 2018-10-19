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

    @GetMapping("/showOneSeason")
    public Season showOneSeason() {
        String match_id = "1"; // TODO: CHANG TO A CORRECT SPRING BOOT GET VARIABLE!

        Season season = seasonService.displayOneSeason(match_id);
        return season;
    }

}