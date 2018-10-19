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

    @GetMapping("/showOneTeam")
    public Team showOneTeam(){
        String teamid = "1";      // TODO: Change the var to proper springboot GET variable
        Team team = teamService.displayOneTeam(teamid);
        return team;
    }

}