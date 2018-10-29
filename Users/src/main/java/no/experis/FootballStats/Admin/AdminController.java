package no.experis.FootballStats.Admin;

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

    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable String id) {
        log.info("Request to delete group: {}", id);
        adminService.deleteAddress(id);
        return ResponseEntity.ok().build();
    }
}
*/

@Controller
public class AdminController{

    private AdminDatabaseManager adminDatabase = new AdminDatabaseManager();
    private AdminService adminService = new AdminService();

    @RequestMapping(method = RequestMethod.PUT, value = "/updateAddress/{addressId}")
    @ResponseBody
    public void updateAddress(@PathVariable int addressId, @RequestBody Address address) {
        adminDatabase.updateAddress(address.getAddress_line_1(), address.getAddress_line_2(), address.getAddress_line_3(), address.getPostal_code(),address.getCity(), address.getCountry(), addressId);
        adminDatabase.updateLocation(address.getName(), address.getDescription(), address.getLocation_id());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createAddress")
    @ResponseBody
    public void createAddress(@RequestBody Address address){
        adminService.createAddress(address);
    }


}
