package no.experis.FootballStats.Admin;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AdminController {

    private AdminService adminService = new AdminService();

    // TODO: Call login logic

    @GetMapping("/admin")
    public String showAdmin() {
        return "{Admin: adminStuff}";
    }

}