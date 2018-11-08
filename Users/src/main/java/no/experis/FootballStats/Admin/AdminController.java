package no.experis.FootballStats.Admin;

import no.experis.FootballStats.Admin.Models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class AdminController{

    private AdminDatabaseManager adminDatabase = new AdminDatabaseManager();
    private AdminService adminService = new AdminService();

    // ADDRESS

    @RequestMapping(method = RequestMethod.POST, value = "/createAddress")
    @ResponseBody
    public void createAddress(@RequestBody Address address){
        adminService.createAddress(address);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateAddress")
    @ResponseBody
    public void updateAddress(@RequestBody Address address) {
        adminService.updateAddress(address);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAddress/{id}")
    @ResponseBody
    public void deleteAddress(@PathVariable String id) {
        adminService.deleteAddress(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteLocation/{id}")
    @ResponseBody
    public void deleteLocation(@PathVariable String id) {
        adminService.deleteLocation(id);
    }

    // PERSON

    @RequestMapping(method = RequestMethod.POST, value = "/createPerson")
    @ResponseBody
    public void createPerson(@RequestBody Person person){
        adminService.createPerson(person);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/updatePerson")
    @ResponseBody
    public void updatePerson(@RequestBody Person person) {
        adminService.updatePerson(person);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/deletePerson/{id}")
    @ResponseBody
    public void deletePerson(@PathVariable int id) {
        adminService.deletePerson(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/createPlayer")
    @ResponseBody
    public void createPlayer(@RequestBody Player player){
        adminService.createPlayer(player);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createCoach")
    @ResponseBody
    public void createCoach(@RequestBody Coach coach){
        adminService.createCoach(coach);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createOwner")
    @ResponseBody
    public void createOwner(@RequestBody Owner owner){
        adminService.createOwner(owner);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/updatePlayer")
    @ResponseBody
    public void updatePlayer(@RequestBody Player player) {
        adminService.updatePlayer(player);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/updateCoach")
    @ResponseBody
    public void updateCoach(@RequestBody Coach coach) {
        adminService.updateCoach(coach);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/updateOwner")
    @ResponseBody
    public void updateOwner(@RequestBody Owner owner) {
        adminService.updateOwner(owner);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletePlayer/{id}")
    @ResponseBody
    public void deletePlayer(@PathVariable int id) {
        adminService.deletePlayer(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteOwner/{id}")
    @ResponseBody
    public void deleteOwner(@PathVariable int id) {
        adminService.deleteOwner(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteCoach/{id}")
    @ResponseBody
    public void deleteCoach(@PathVariable int id) {
        adminService.deleteCoach(id);
    }

    // GOAL

    @RequestMapping(method = RequestMethod.POST, value = "/createGoal")
    @ResponseBody
    public void createGoal(@RequestBody Goal goal){
        adminService.createGoal(goal);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateGoal")
    @ResponseBody
    public void updateGoal(@RequestBody Goal goal) {
        adminService.updateGoal(goal);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteGoal/{id}")
    @ResponseBody
    public void deleteGoal(@PathVariable int id) {
        adminService.deleteGoal(id);
    }

    // GOAL TYPE

    @RequestMapping(method = RequestMethod.POST, value = "/createGoalType")
    @ResponseBody
    public void createGoalType(@RequestBody Goal goal){
        adminService.createGoalType(goal);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateGoalType")
    @ResponseBody
    public void updateGoalType(@RequestBody Goal goal) {
        adminService.updateGoalType(goal);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteGoalType/{id}")
    @ResponseBody
    public void deleteGoalType(@PathVariable int id) {
        adminService.deleteGoalType(id);
    }

    // MATCH

    @RequestMapping(method = RequestMethod.POST, value = "/createMatch")
    @ResponseBody
    public void createMatch(@RequestBody Match match){
        adminService.createMatch(match);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateMatch")
    @ResponseBody
    public void updateMatch(@RequestBody Match match) {
        adminService.updateMatch(match);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteMatch/{id}")
    @ResponseBody
    public void deleteMatch(@PathVariable int id) {
        adminService.deleteMatch(id);
    }

    // RESULT

    @RequestMapping(method = RequestMethod.POST, value = "/createResult")
    @ResponseBody
    public void createResult(@RequestBody Result result){
        adminService.createResult(result);
    }

    // **** NEEDS TO SEND THE OLD VALUE FOR TEAM_ID AND MATCH_ID ****
    @RequestMapping(method = RequestMethod.PUT, value = "/updateResult/{old_team_id}/{old_match_id}")
    @ResponseBody
    public void updateResult(@PathVariable int old_team_id, int old_match_id, @RequestBody Result result) {
        adminService.updateResult(result, old_team_id, old_match_id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteResult/{match_id}/{team_id}")
    @ResponseBody
    public void deleteResult(@PathVariable int match_id, int team_id) {
        adminService.deleteResult(match_id, team_id);
    }

    // SEASON
    @RequestMapping(method = RequestMethod.POST, value = "/createSeason")
    @ResponseBody
    public void createSeason(@RequestBody Season season){
        adminService.createSeason(season);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateSeason")
    @ResponseBody
    public void updateMatch(@RequestBody Season season) {
        adminService.updateSeason(season);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteSeason/{id}")
    @ResponseBody
    public void deleteSeason(@PathVariable int id) {
        adminService.deleteSeason(id);
    }


    // ASSOCIATION

    @RequestMapping(method = RequestMethod.POST, value = "/createAssociation")
    @ResponseBody
    public void createAssociation(@RequestBody Association association){
        adminService.createAssociation(association);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateAssociation")
    @ResponseBody
    public void updateAssociation(@RequestBody Association association) {
        adminService.updateAssociation(association);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAssociation/{id}")
    @ResponseBody
    public void deleteAssociation(@PathVariable int id) {
        adminService.deleteAssociation(id);
    }

    // TEAM
    @RequestMapping(method = RequestMethod.POST, value = "/createTeam")
    @ResponseBody
    public void createTeam(@RequestBody Team team){
        adminService.createTeam(team);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateTeam")
    @ResponseBody
    public void updateTeam(@RequestBody Team team) {
        adminService.updateTeam(team);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteTeam/{id}")
    @ResponseBody
    public void deleteTeam(@PathVariable int id) {
        adminService.deleteTeam(id);
    }

    // CONTACTS

    @GetMapping("/showContacts")
    public List showContacts() {
        return adminService.displayContacts();
    }

    @GetMapping("/showContacts/{someID}")
    public Contact showOneContact(@PathVariable(value="someID") int id){
        return adminService.displayOneContact(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createContact")
    @ResponseBody
    public void createContact(@RequestBody Contact contact){
        adminService.createContact(contact);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateContact")
    @ResponseBody
    public void updateContact(@RequestBody Contact contact) {
        adminService.updateContact(contact);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteContact/{id}")
    @ResponseBody
    public void deleteContact(@PathVariable int id) {
        adminService.deleteContact(id);
    }


    // ADMIN DASHBOARD

    @GetMapping("/getAllDashboardData")
    public int[] getAllDashboardData() {
        return adminService.getDashboardData();
    }


    @GetMapping("/getCountPlayers")
    public int getCountPlayers() {
        return adminService.getCountPlayersFromDB();
    }


    @GetMapping("/getCountTeams")
    public int getCountTeams() {
        return adminService.getCountTeamsFromDB();
    }


    @GetMapping("/getCountMatches")
    public int getCountMatches() {
        return adminService.getCountMatchesFromDB();
    }


    @GetMapping("/getCountSeasons")
    public int getCountSeasons() {
        return adminService.getCountSeasonsFromDB();
    }


    @GetMapping("/getCountGoals")
    public int getCountGoals() {
        return adminService.getCountGoalsFromDB();
    }


    @GetMapping("/getCountUsers")
    public int getCountUsers() {
        return adminService.getCountUsersFromDB();
    }

    @GetMapping("/getNews")
    public ArrayList<String> getNews() {
        return adminService.getNewsFromDB();
    }

    @GetMapping("/getUserNews/{someID}")
    public ArrayList<String> getUserNews(@PathVariable(value="someID") int id) {
        return adminDatabase.getUserNews(id);
    }

}
