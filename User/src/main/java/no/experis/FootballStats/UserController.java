package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    private UserService userService = new UserService();

    // TODO: Call login logic




/*
    @GetMapping("/showPlayers")
    public List showPlayers() {
        List<User> players = userService.displayAllPlayers();
        return players;
    }

    @GetMapping("/showOnePlayer/{someID}")
    public User showOnePlayer(@PathVariable(value="someID") String id){
        User player = userService.displayOnePlayer(id);
        return player;
    }
*/

}