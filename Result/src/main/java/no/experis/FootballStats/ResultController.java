package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ResultController {

    private ResultService resultService = new ResultService();

    @GetMapping("/showResults")
    public List showAddresses() {
        List<Result> results = resultService.displayAllResults();
        return results;
    }

    @GetMapping("/showOneResult/{someID}")
    public Result showAddress(@PathVariable(value="someID") String id){
        Result result = resultService.displayOneResult(id);
        return result;
    }

}