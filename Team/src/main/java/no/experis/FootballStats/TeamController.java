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


    @GetMapping("/showAssociations")
    public List showAssociations() {
        return teamService.displayAllAssociations();
    }

    @GetMapping("/showAssociations/{someID}")
    public Association showOneAssociation(@PathVariable(value="someID") String id){
        return teamService.displayOneAssociation(id);
    }

    @GetMapping("/showAllTeamData")
    public List showAllTeamData() {
        return teamService.displayAllTeamData();
    }

    @GetMapping("/showAllTeamData/{someID}")
    public FootballTeam showOneFootballTeam(@PathVariable(value="someID") String id){
        return teamService.displayOneTeamData(id);
    }


}