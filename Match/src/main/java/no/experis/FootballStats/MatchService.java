package no.experis.FootballStats;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    private DatabaseManager dbManager = new DatabaseManager();

    public List<Match> displayAllMatches(){
        ArrayList<Match> match = new ArrayList<Match>();

        match.addAll(dbManager.getMatches());

        return match;
    }


}
