package no.experis.FootballStats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private PersonService personService;

    @GetMapping("/test")
    public List<Person> getPeople(){

        List<Person> people = personService.displayAllPersons();

        return people;
    }
}
