package no.experis.FootballStats;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    private DatabaseManager dbManager = new DatabaseManager();

    public List<Match> displayAllMatches(){
        ArrayList<Match> matches = new ArrayList<Match>();

        matches.addAll(dbManager.getMatches());

        return matches;
    }

    public Match displayOneMatch(String match_id){
        ArrayList<Match> matches = new ArrayList<Match>();
        matches.addAll(dbManager.getMatches());

        for(Match match : matches){
            if(match.getMatch_id().equals(match_id)){
                return match;
            }
        }
        return null;
    }

    public List<Match> displayUpcommingMatches(){
        ArrayList<Match> matches = new ArrayList<Match>();

        matches.addAll(dbManager.getUpcommingMatches());

        return matches;
    }




}
