package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonController {

    private PersonService personService = new PersonService();

    @GetMapping("/showPlayers")
    public List showPlayers() {
        List<Player> players = personService.displayAllPlayers();
        return players;
    }

    @GetMapping("/showOnePlayer/{someID}")
    public Player showOnePlayer(@PathVariable(value="someID") String id){
        Player player = personService.displayOnePlayer(id);
        return player;
    }

    @GetMapping("/showPlayersInTeam/{someID}")
    public List displayAllPlayersInTeam(@PathVariable(value="someID") String id){
        List<Player> players = personService.displayAllPlayersInTeam(id);
        return players;
    }

    @GetMapping("/showCoaches")
    public List showCoaches() {
        List<Coach> coaches = personService.displayAllCoaches();
        return coaches;
    }

    @GetMapping("/showOneCoach/{someID}")
    public Coach showOneCoach(@PathVariable(value="someID") String id){
        Coach coach = personService.displayOneCoach(id);
        return coach;
    }

    @GetMapping("/showOwners")
    public List showOwners() {
        List<Owner> owners = personService.displayAllOwners();
        return owners;
    }

    @GetMapping("/showOneOwner/{someID}")
    public Owner showOneOwner(@PathVariable(value="someID") String id){
        Owner owner = personService.displayOneOwner(id);
        return owner;
    }

    @GetMapping("/test")
    public void test() {
        //    REMOVE COMMENT TO CREATE A NEW DATABASE
        //    personService.createNewDatabase();
    }

}