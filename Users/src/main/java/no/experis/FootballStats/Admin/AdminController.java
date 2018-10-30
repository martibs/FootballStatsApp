package no.experis.FootballStats.Admin;

import no.experis.FootballStats.Admin.AdminDatabaseManager;
import no.experis.FootballStats.Admin.AdminService;
import no.experis.FootballStats.Admin.Models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping(method = RequestMethod.PUT, value = "/updateAddress/{addressId}")
    @ResponseBody
    public void updateAddress(@PathVariable int addressId, @RequestBody Address address) {
        adminService.updateAddress(address, addressId);
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


    @RequestMapping(method = RequestMethod.PUT, value = "/updatePlayer/{personId}")
    @ResponseBody
    public void updatePlayer(@PathVariable int personId, @RequestBody Player player) {
        adminService.updatePlayer(player);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/updateCoach/{personId}")
    @ResponseBody
    public void updateCoach(@PathVariable int personId, @RequestBody Coach coach) {
        adminService.updateCoach(coach);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/updateOwner/{personId}")
    @ResponseBody
    public void updateOwner(@PathVariable int personId, @RequestBody Owner owner) {
        adminService.updateOwner(owner);
    }

/*

    // GOAL

    @RequestMapping(method = RequestMethod.POST, value = "/createGoal")
    @ResponseBody
    public void createGoal(@RequestBody Goal goal){
        adminService.createGoal(goal);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/updateGoal/{goal_id}")
    @ResponseBody
    public void updateGoal(@PathVariable int goal_id, @RequestBody Goal goal) {
        adminService.updateGoal(goal);
    }
*/

    // MATCH



    // RESULT



    // SEASON



    // TEAM




}
