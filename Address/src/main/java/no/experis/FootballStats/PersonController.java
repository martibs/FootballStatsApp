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

}