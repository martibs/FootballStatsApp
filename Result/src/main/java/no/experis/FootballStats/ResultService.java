package no.experis.FootballStats;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {

    private DatabaseManager dbManager = new DatabaseManager();

    // Players
    public List<Result> displayAllResults(){
        ArrayList<Result> results = new ArrayList<Result>();

        results.addAll(dbManager.getResults());

        return results;
    }


    public ArrayList<Result> displayOneResult(String match_id){
        ArrayList<Result> results = new ArrayList<Result>();
        ArrayList<Result> resultswithid = new ArrayList<Result>();
        results.addAll(dbManager.getResults());

        for(Result result : results){
            if(result.getMatch_id().equals(match_id)){
                resultswithid.add(result);
            }
        }
        return resultswithid;
    }

}
