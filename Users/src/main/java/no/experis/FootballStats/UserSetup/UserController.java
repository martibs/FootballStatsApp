package no.experis.FootballStats.UserSetup;

import no.experis.FootballStats.Admin.Models.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController{

    private UserService userService = new UserService();

    @GetMapping("/showUsers")
    public List showUsers() {
        return userService.displayUsers();
    }

    @GetMapping("/showOneUser/{someID}")
    public User showOneContact(@PathVariable(value="someID") String id){
        return userService.displayOneUser(id);
    }



}

