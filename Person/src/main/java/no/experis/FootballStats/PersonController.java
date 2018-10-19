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

    @GetMapping("/showOnePlayer")
    public Player showOnePlayer(){
        String playerid = "1";      // TODO: Change the var to proper springboot GET variable
        Player player = personService.displayOnePlayer(playerid);
        return player;
    }


    @GetMapping("/showCoaches")
    public List showCoaches() {
        List<Coach> coaches = personService.displayAllCoaches();
        return coaches;
    }

    @GetMapping("/showOneCoach")
    public Coach showOneCoach(){
        String coachid = "2";      // TODO: Change the var to proper springboot GET variable
        Coach coach = personService.displayOneCoach(coachid);
        return coach;
    }

    @GetMapping("/showOwners")
    public List showOwners() {
        List<Owner> owners = personService.displayAllOwners();
        return owners;
    }

    @GetMapping("/showOneOwner")
    public Owner showOneOwner(){
        String ownerid = "3";      // TODO: Change the var to proper springboot GET variable
        Owner owner = personService.displayOneOwner(ownerid);
        return owner;
    }

    @GetMapping("/test")
    public void test() {
        personService.updateTest();
    }


}