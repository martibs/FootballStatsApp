package no.experis.FootballStats.Admin;

import no.experis.FootballStats.Admin.Models.*;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminDatabaseManager adminDbManager = new AdminDatabaseManager();


    // ADDRESS

    public void createAddress(Address address){
        int id = adminDbManager.createAddress(address.getAddress_line_1(), address.getAddress_line_2(), address.getAddress_line_3(), address.getPostal_code(),address.getCity(), address.getCountry());
        adminDbManager.createLocation(address.getLocation_name(), address.getDescription(), id);
    }

    public void updateAddress(Address address){
        adminDbManager.updateAddress(address.getAddress_line_1(), address.getAddress_line_2(), address.getAddress_line_3(), address.getPostal_code(),address.getCity(), address.getCountry(), address.getAddress_id());
        adminDbManager.updateLocation(address.getLocation_name(), address.getDescription(), address.getLocation_id());
    }

    public void deleteAddress(String address_id){
        adminDbManager.deleteAddress(address_id);
    }

    // PERSON

    public void createPlayer(Player player){
        int id = adminDbManager.createPerson(player.getFirst_name(), player.getLast_name(), player.getDate_of_birth(), player.getAddress_id());
        adminDbManager.createPlayer(player.getNormal_position(), player.getNumber(), id, player.getTeam_id());
    }

    public void createCoach(Coach coach){
        int id = adminDbManager.createPerson(coach.getFirst_name(), coach.getLast_name(), coach.getDate_of_birth(), coach.getAddress_id());
        adminDbManager.createCoach(id);
    }

    public void createOwner(Owner owner){
        int id = adminDbManager.createPerson(owner.getFirst_name(), owner.getLast_name(), owner.getDate_of_birth(), owner.getAddress_id());
        adminDbManager.createOwner(id);
    }

    public void updatePlayer(Player player){
        int id = adminDbManager.updatePerson(player.getFirst_name(), player.getLast_name(), player.getDate_of_birth(), player.getAddress_id());
        adminDbManager.updatePlayer(player.getNormal_position(), player.getNumber(), id, player.getTeam_id());
    }

    public void updateCoach(Coach coach){
        int id = adminDbManager.updatePerson(coach.getFirst_name(), coach.getLast_name(), coach.getDate_of_birth(), coach.getAddress_id());
        adminDbManager.updateCoach(id, coach.getCoach_id());
    }

    public void updateOwner(Owner owner){
        int id = adminDbManager.updatePerson(owner.getFirst_name(), owner.getLast_name(), owner.getDate_of_birth(), owner.getAddress_id());
        adminDbManager.updateOwner(id, owner.getOwner_id());
    }


    // GOAL
    public void createGoal(Goal goal){
        adminDbManager.createMatchGoal(goal.getDescription(), goal.getGoal_type_id(), goal.getMatch_id(), goal.getPlayer_id());
    }

    public void updateGoal(Goal goal){
        adminDbManager.updateMatchGoal(goal.getDescription(), goal.getGoal_type_id(), goal.getMatch_id(), goal.getPlayer_id(), goal.getGoal_id());
    }


    // MATCH

    public void createMatch(Match match){
        adminDbManager.createMatch(match.getMatch_date(), match.getSeason_id(), match.getLocation_id(), match.getHome_team_id(), match.getAway_team_id());
    }

    public void updateMatch(Match match){
        adminDbManager.updateMatch(match.getMatch_date(), match.getSeason_id(), match.getLocation_id(), match.getHome_team_id(), match.getAway_team_id(), match.getMatch_id());
    }



    // RESULT

    public void createResult(Result result){
        adminDbManager.createResult(result.getScore(), result.getResult(), result.getMatch_id(), result.getTeam_id());
    }

    public void updateResult(Result result, int old_team_id, int old_match_id){
        adminDbManager.updateResult(result.getScore(), result.getResult(), result.getMatch_id(), result.getTeam_id(), old_team_id, old_match_id);
    }


    // SEASON

    public void createSeason(Season season){
        adminDbManager.createSeason(season.getStart_date(), season.getEnd_date(), season.getName(), season.getDescription());
    }

    public void updateSeason(Season season){
        adminDbManager.updateSeason(season.getStart_date(), season.getEnd_date(), season.getName(), season.getDescription(), season.getSeason_id());
    }



    // TEAM
    public void createTeam(Team team){
        adminDbManager.createTeam(team.getOwner_id(), team.getAssociation_id(), team.getCoach_id(), team.getLocation_id());
    }

    public void updateTeam(Team team){
        int id = adminDbManager.updateTeam(team.getOwner_id(), team.getAssociation_id(), team.getCoach_id(), team.getLocation_id(), team.getTeam_id());
        adminDbManager.updateAssociation(team.getAssociation_name(), team.getAssociation_description(), id);
    }



}