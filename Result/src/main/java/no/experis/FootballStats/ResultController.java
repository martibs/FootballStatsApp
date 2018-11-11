package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResultController {

    private ResultService resultService = new ResultService();

    @GetMapping("/showResults")
    public List showAddresses() {
        return resultService.displayAllResults();
    }

    @GetMapping("/showOneResult/{someID}")
    public ArrayList<Result> showAddress(@PathVariable(value="someID") String id){
        return resultService.displayOneResult(id);
    }

}