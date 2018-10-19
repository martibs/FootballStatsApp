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

    @GetMapping("/showOneResult")
    public Result showAddress(){
        String resultid = "1";      // TODO: Change the var to proper springboot GET variable
        Result result = resultService.displayOneResult(resultid);
        return result;
    }

}