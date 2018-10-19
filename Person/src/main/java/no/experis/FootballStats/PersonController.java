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

    @GetMapping("/showCoaches")
    public List showCoaches() {
        List<Coach> coaches = personService.displayAllCoaches();
        return coaches;
    }

    @GetMapping("/showOwners")
    public List showOwners() {
        List<Owner> owners = personService.displayAllOwners();
        return owners;
    }

}