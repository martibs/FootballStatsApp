package no.experis.FootballStats;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private DatabaseManager dbManager = new DatabaseManager();

    // Teams
    public List<Team> displayAllTeams() {
        ArrayList<Team> people = new ArrayList<Team>();

        people.addAll(dbManager.getTeams());

        return people;
    }


    public Team displayOneTeam(String player_id) {
        ArrayList<Team> teams = new ArrayList<Team>();
        teams.addAll(dbManager.getTeams());

        for (Team team : teams) {
            if (team.getTeam_id().equals(player_id)) {
                return team;
            }
        }
        return null;
    }
}