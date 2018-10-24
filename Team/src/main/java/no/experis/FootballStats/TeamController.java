package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TeamController {

    private TeamService teamService = new TeamService();

    @GetMapping("/showTeams")
    public List showTeams() {
        return teamService.displayAllTeams();
    }

    @GetMapping("/showOneTeam/{someID}")
    public Team showOneTeam(@PathVariable(value="someID") String id){
        return teamService.displayOneTeam(id);
    }



}