package no.experis.FootballStats.Admin;

import no.experis.FootballStats.Admin.Models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
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


    // PERSON

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

    // TODO: CREATE GOAL TYPE

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


/*
@RestController
public class AdminController {
    private AdminDatabaseManager adminDatabase = new AdminDatabaseManager();
    private AdminService adminService = new AdminService();

    private final Logger log = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/showAddresses")
    public List showAddresses() {
        return adminService.displayAllAddresses();
    }

    @GetMapping("/showOneAddress/{someID}")
    public Address showAddress(@PathVariable(value="someID") String id){
        return adminService.displayOneAddress(id);
    }

    @PostMapping("/createAddress")
    ResponseEntity<Address> createAddress(@Valid @RequestBody Address address) throws URISyntaxException {
        log.info("Request to create group: {}", address);
        Address result = adminDatabase.createAddress(address.getAddress_line_1(), address.getAddress_line_2(), address.getAddress_line_3(), address.getPostal_code(),address.getCity(), address.getCountry());
        return ResponseEntity.created(new URI("/createAddress" + result.getAddress_id())).body(result);
    }

    @PutMapping("/updateAddress/{id}")
    ResponseEntity<Address> updateAddress(@PathVariable String id, @Valid @RequestBody Address address) {
        System.out.println("this is the object: " + address);

        address.setAddress_id(id);
        log.info("Request to update group: {}", address);
        Address result = adminDatabase.updateAddress(address.getAddress_line_1(), address.getAddress_line_2(), address.getAddress_line_3(), address.getPostal_code(),address.getCity(), address.getCountry(), address.getAddress_id());
        return ResponseEntity.ok().body(result);
    }

*/


}
