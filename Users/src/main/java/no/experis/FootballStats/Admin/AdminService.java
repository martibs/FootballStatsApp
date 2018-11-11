package no.experis.FootballStats.Admin;

import no.experis.FootballStats.Admin.Models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    private AdminDatabaseManager adminDbManager = new AdminDatabaseManager();
    private int id;

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

    public void deleteLocation(String location_id){
        adminDbManager.deleteLocation(location_id);
    }

    // PERSON

    public void createPerson(Person person){
        adminDbManager.createPerson(person.getFirst_name(), person.getLast_name(), person.getDate_of_birth(), person.getAddress_id());
    }

    public void updatePerson(Person person){
        adminDbManager.updatePerson(person.getFirst_name(), person.getLast_name(), person.getDate_of_birth(), person.getAddress_id(),Integer.parseInt(person.getPerson_id()));
    }

    public void deletePerson(int person_id){
        adminDbManager.deletePerson(person_id);
    }

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
        int id = adminDbManager.updatePerson(player.getFirst_name(), player.getLast_name(), player.getDate_of_birth(), player.getAddress_id(),Integer.parseInt(player.getPerson_id()));
        adminDbManager.updatePlayer(player.getNormal_position(), player.getNumber(), player.getTeam_id(), id);
    }

    public void updatePlayerImage(Player player){
        adminDbManager.updatePlayerImage(player.getPlayer_image(), Integer.parseInt(player.getPlayer_id()));
    }

    public void updateCoach(Coach coach){
        int id = adminDbManager.updatePerson(coach.getFirst_name(), coach.getLast_name(), coach.getDate_of_birth(), coach.getAddress_id(),Integer.parseInt(coach.getPerson_id()));
        adminDbManager.updateCoach(id, coach.getCoach_id());
    }

    public void updateOwner(Owner owner){
        int id = adminDbManager.updatePerson(owner.getFirst_name(), owner.getLast_name(), owner.getDate_of_birth(), owner.getAddress_id(),Integer.parseInt(owner.getPerson_id()));
        adminDbManager.updateOwner(id, owner.getOwner_id());
    }

    public void deletePlayer(int person_id){
        adminDbManager.deletePlayer(person_id);
    }

    public void deleteCoach(int person_id){
        adminDbManager.deleteCoach(person_id);
    }

    public void deleteOwner(int person_id){
        adminDbManager.deleteOwner(person_id);
    }


    // GOAL
    public void createGoal(Goal goal){
        adminDbManager.createMatchGoal(goal.getDescription(), goal.getGoal_type_id(), goal.getMatch_id(), goal.getPlayer_id());
    }

    public void updateGoal(Goal goal){
        adminDbManager.updateMatchGoal(goal.getDescription(), goal.getGoal_type_id(), goal.getMatch_id(), goal.getPlayer_id(), goal.getGoal_id());
    }

    public void deleteGoal(int goal_id){
        adminDbManager.deleteMatchGoal(goal_id);
    }

    // GOAL TYPE

    public void createGoalType(Goal goal){
        adminDbManager.createGoalType(goal.getType());
    }

    public void updateGoalType(Goal goal){
        adminDbManager.updateGoalType(goal.getType(),goal.getGoal_type_id());
    }

    public void deleteGoalType(int goal_id){
        adminDbManager.deleteGoalType(goal_id);
    }


    // MATCH

    public void createMatch(Match match){
        adminDbManager.createMatch(match.getMatch_date(), match.getSeason_id(), match.getLocation_id(), match.getHome_team_id(), match.getAway_team_id());
    }

    public void updateMatch(Match match){
        adminDbManager.updateMatch(match.getMatch_date(), match.getSeason_id(), match.getLocation_id(), match.getHome_team_id(), match.getAway_team_id(), match.getMatch_id());
    }

    public void deleteMatch(int match_id){
        adminDbManager.deleteMatch(match_id);
    }

    // RESULT

    public void createResult(Result result){
        adminDbManager.createResult(result.getScore(), result.getResult(), result.getMatch_id(), result.getTeam_id());
    }

    public void updateResult(Result result, int old_team_id, int old_match_id){
        adminDbManager.updateResult(result.getScore(), result.getResult(), result.getMatch_id(), result.getTeam_id(), old_team_id, old_match_id);
    }

    public void deleteResult(int match_id, int team_id){
        adminDbManager.deleteResult(match_id, team_id);
    }


    // SEASON

    public void createSeason(Season season){
        adminDbManager.createSeason(season.getStart_date(), season.getEnd_date(), season.getName(), season.getDescription());
    }

    public void updateSeason(Season season){
        adminDbManager.updateSeason(season.getStart_date(), season.getEnd_date(), season.getName(), season.getDescription(), season.getSeason_id());
    }

    public void deleteSeason(int season_id){
        adminDbManager.deleteSeason(season_id);
    }


    // TEAM
    public void createTeam(Team team){
        System.out.println("team used of id " + id);
        adminDbManager.createTeam(id, team.getCoach_id(), team.getOwner_id(), team.getLocation_id());

    }

    public void updateTeam(Team team){
        adminDbManager.updateTeam(team.getTeam_id(), team.getAssociation_id(), team.getCoach_id(), team.getOwner_id(), team.getLocation_id());
    }

    public void updateTeamImage(Team team){
        adminDbManager.updateTeamImage(team.getTeam_image(),team.getTeam_id());
    }

    public void deleteTeam(int team_id){
        adminDbManager.deleteTeam(team_id);
    }


    // ASSOCIATION

    public void createAssociation(Association association){
        id = adminDbManager.createAssociation(association.getAssociation_name(), association.getAssociation_description());
        System.out.println("association create id = " + id);
    }

    public void updateAssociation(Association association){
        adminDbManager.updateAssociation(association.getAssociation_name(), association.getAssociation_description(), association.getAssociation_id());
    }

    public void deleteAssociation(int association_id){
        adminDbManager.deleteAssociation(association_id);
    }

    // CONTACT

    public List<Contact> displayContacts(){
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        contacts.addAll(adminDbManager.getContacts());
        return contacts;
    }

    public Contact displayOneContact(int id){
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        contacts.addAll(adminDbManager.getContacts());

        for(Contact contact : contacts){
            if(contact.getPerson_id().equals(id)){
                return contact;
            }
        }
        return null;
    }

    public void createContact(Contact contact){
        adminDbManager.createContact(contact.getContact_type(), contact.getContact_detail(), contact.getPerson_id());
    }

    public void updateContact(Contact contact){
        adminDbManager.updateContact(contact.getContact_type(), contact.getContact_detail(), contact.getPerson_id());
    }

    public void deleteContact(int contact_id){
        adminDbManager.deleteContact(contact_id);
    }

    // DASHBOARD ADMIN METHODS

    public int[] getDashboardData(){
        int[] list  = new int[6];
        list[0] = adminDbManager.getCountPlayers();
        list[1] = adminDbManager.getCountTeams();
        list[2] = adminDbManager.getCountMatches();
        list[3] = adminDbManager.getCountSeasons();
        list[4] = adminDbManager.getCountGoals();
        list[5] = adminDbManager.getCountUsers();

        return list;
    }

    public int getCountPlayersFromDB(){
        return adminDbManager.getCountPlayers();
    }

    public int getCountTeamsFromDB(){
        return adminDbManager.getCountTeams();
    }

    public int getCountMatchesFromDB(){
        return adminDbManager.getCountMatches();
    }

    public int getCountSeasonsFromDB(){
        return adminDbManager.getCountSeasons();
    }

    public int getCountGoalsFromDB(){
        return adminDbManager.getCountGoals();
    }

    public int getCountUsersFromDB(){
        return adminDbManager.getCountUsers();
    }

    //NEWS
    public ArrayList<String> getNewsFromDB(){
        ArrayList<String> list  = new ArrayList<>();
        list.addAll(adminDbManager.getNews());

        return list;
    }

    public void createNews(News news) {
        adminDbManager.createNews(news.getNews_string(), news.getTeam_id(), news.getPlayer_id());
    }

    public void createUserWatchPlayer(Watchlist watchlist){adminDbManager.createUserWatchPlayer(watchlist.getWatch_id(),watchlist.getUser_id());}

    public void createUserWatchTeam(Watchlist watchlist){adminDbManager.createUserWatchTeam(watchlist.getWatch_id(),watchlist.getUser_id());}


}