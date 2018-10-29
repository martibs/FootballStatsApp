package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonController {

    private PersonService personService = new PersonService();

    // PLAYERS

    @GetMapping("/showPlayers")
    public List showPlayers() {
        return personService.displayAllPlayers();
    }

    @GetMapping("/showOnePlayer/{someID}")
    public Player showOnePlayer(@PathVariable(value="someID") String id){
        return personService.displayOnePlayer(id);
    }

    @GetMapping("/showPlayersInTeam/{someID}")
    public List displayAllPlayersInTeam(@PathVariable(value="someID") String id){
        return personService.displayAllPlayersInTeam(id);
    }

    // COACHES

    @GetMapping("/showCoaches")
    public List showCoaches() {
        return personService.displayAllCoaches();
    }

    @GetMapping("/showOneCoach/{someID}")
    public Coach showOneCoach(@PathVariable(value="someID") String id){
        return personService.displayOneCoach(id);
    }

    // OWNERS

    @GetMapping("/showOwners")
    public List showOwners() {
        return personService.displayAllOwners();
    }

    @GetMapping("/showOneOwner/{someID}")
    public Owner showOneOwner(@PathVariable(value="someID") String id){
        return personService.displayOneOwner(id);
    }

    @GetMapping("/test")
    public void test() {
        //    REMOVE COMMENT TO CREATE A NEW DATABASE
        personService.createNewDatabase();
    }

}