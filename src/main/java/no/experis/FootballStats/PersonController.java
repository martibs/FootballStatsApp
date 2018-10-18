package no.experis.FootballStats;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PersonController {
/*
    @Autowired
    private DatabaseManager dbManager = new DatabaseManager();
*/
    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String index (){
        return "index";
    }

    @RequestMapping("/showPeople")
    public ModelAndView showPerson() {

        List<Person> people = personService.displayAllPersons();

        Map<String, Object> params = new HashMap<>();
        params.put("people", people);

        return new ModelAndView("showPeople", params);
    }

}