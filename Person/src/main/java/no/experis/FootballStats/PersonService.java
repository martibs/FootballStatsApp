package no.experis.FootballStats;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private DatabaseManager dbManager = new DatabaseManager();

    public List<Player> displayAllPlayers(){
        ArrayList<Player> people = new ArrayList<Player>();

        people.addAll(dbManager.getPlayers());

        return people;
    }

    public List<Coach> displayAllCoaches(){
        ArrayList<Coach> people = new ArrayList<Coach>();

        people.addAll(dbManager.getCoaches());

        return people;
    }

    public List<Owner> displayAllOwners(){
        ArrayList<Owner> people = new ArrayList<Owner>();

        people.addAll(dbManager.getOwners());

        return people;
    }


}
