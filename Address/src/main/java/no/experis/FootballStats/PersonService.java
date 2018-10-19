package no.experis.FootballStats;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private DatabaseManager dbManager = new DatabaseManager();

    // Players
    public List<Player> displayAllPlayers(){
        ArrayList<Player> people = new ArrayList<Player>();

        people.addAll(dbManager.getPlayers());

        return people;
    }


    public Player displayOnePlayer(String player_id){
        ArrayList<Player> players = new ArrayList<Player>();
        players.addAll(dbManager.getPlayers());

        for(Player player : players){
            if(player.getPlayer_id().equals(player_id)){
                return player;
            }
        }
        return null;
    }

}
