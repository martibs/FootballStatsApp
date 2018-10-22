package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TeamController {

    private TeamService teamService = new TeamService();

    @GetMapping("/showTeams")
    public List showTeams() {
        List<Team> teams = teamService.displayAllTeams();
        return teams;
    }

    @GetMapping("/showOneTeam/{someID}")
    public Team showOneTeam(@PathVariable(value="someID") String id){
        Team team = teamService.displayOneTeam(id);
        return team;
    }

}