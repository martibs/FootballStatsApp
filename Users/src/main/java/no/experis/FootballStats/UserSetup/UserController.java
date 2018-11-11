package no.experis.FootballStats.UserSetup;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private UserService userService = new UserService();

    @GetMapping("/user")
    public String showUser() {
        return "{User: userStuff}";
    }



    @GetMapping("/userID/{email}")
    public User showUserId(@PathVariable(value="email") String email) {
        return userService.showUserId(email);
    }

}

