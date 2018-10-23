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
    public List<Player> displayAllPlayersInTeam(String team_id){
        List<Player> players = displayAllPlayers();

        ArrayList<Player> playersInTeamList = new ArrayList<Player>();

        for (Player player : players){
            if(player.getTeam_id().equals(team_id)){
                playersInTeamList.add(player);
            }

        }
        return playersInTeamList;
    }

    // Coaches

    public List<Coach> displayAllCoaches(){
        ArrayList<Coach> people = new ArrayList<Coach>();

        people.addAll(dbManager.getCoaches());

        return people;
    }


    public Coach displayOneCoach(String coach_id){
        ArrayList<Coach> coaches = new ArrayList<Coach>();
        coaches.addAll(dbManager.getCoaches());

        for(Coach coach : coaches){
            if(coach.getCoach_id().equals(coach_id)){
                return coach;
            }
        }
        return null;
    }


    // Owners

    public List<Owner> displayAllOwners(){
        ArrayList<Owner> people = new ArrayList<Owner>();

        people.addAll(dbManager.getOwners());

        return people;
    }

    public Owner displayOneOwner(String owner_id){
        ArrayList<Owner> owners = new ArrayList<Owner>();
        owners.addAll(dbManager.getOwners());

        for(Owner owner : owners){
            if(owner.getOwner_id().equals(owner_id)){
                return owner;
            }
        }
        return null;
    }


    // Creates a new database
    public void createNewDatabase(){
        dbManager.createNewDatabase();
    }

}
