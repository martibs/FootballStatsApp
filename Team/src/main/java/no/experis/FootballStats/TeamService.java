package no.experis.FootballStats;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private DatabaseManager dbManager = new DatabaseManager();

    // Teams
    public List<Team> displayAllTeams() {
        ArrayList<Team> teams = new ArrayList<Team>();

        teams.addAll(dbManager.getTeams());

        return teams;
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

    // Association
    public List<Association> displayAllAssociations() {
        ArrayList<Association> associations = new ArrayList<Association>();

        associations.addAll(dbManager.getAssociations());

        return associations;
    }


    public Association displayOneAssociation(String association_id) {
        ArrayList<Association> associationArrayList = new ArrayList<Association>();
        associationArrayList.addAll(dbManager.getAssociations());

        for (Association association : associationArrayList) {
            if (association.getAssociation_id().equals(association_id)) {
                return association;
            }
        }
        return null;
    }

    public List<FootballTeam> displayAllTeamData(){
        ArrayList<FootballTeam> list = new ArrayList<FootballTeam>();

        list.addAll(dbManager.getAllTeamData());

        return list;
    }

    public FootballTeam displayOneTeamData(String player_id) {
        ArrayList<FootballTeam> teams = new ArrayList<FootballTeam>();
        teams.addAll(dbManager.getAllTeamData());

        for (FootballTeam team : teams) {
            if (team.getTeam_id().equals(player_id)) {
                return team;
            }
        }
        return null;
    }

}