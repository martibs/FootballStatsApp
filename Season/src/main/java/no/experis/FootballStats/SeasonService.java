package no.experis.FootballStats;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeasonService {

    private DatabaseManager dbManager = new DatabaseManager();

    public List<Season> displayAllSeasons(){
        ArrayList<Season> seasons = new ArrayList<Season>();
        seasons.addAll(dbManager.getSeasons());

        return seasons;
    }

    public Season displayOneSeason(String season_id){
        ArrayList<Season> seasons = new ArrayList<Season>();
        seasons.addAll(dbManager.getSeasons());

        for(Season season : seasons){
            if(season.getSeason_id().equals(season_id)){
                return season;
            }
        }
        return null;
    }

}
