package no.experis.FootballStats.Admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AdminController {

    private AdminDatabaseManager adminDatabase = new AdminDatabaseManager();
    private AdminService addressService = new AdminService();


    private final Logger log = LoggerFactory.getLogger(AdminController.class);

    // TODO: Call login logic

    @GetMapping("/showAddresses")
    public List showAddresses() {
        return addressService.displayAllAddresses();
    }

    @GetMapping("/showOneAddress/{someID}")
    public Address showAddress(@PathVariable(value="someID") String id){
        return addressService.displayOneAddress(id);
    }


    @PostMapping("/address")
    ResponseEntity<Address> createGroup(@Valid @RequestBody Address address) throws URISyntaxException {
        log.info("Request to create group: {}", address);
        Address result = adminDatabase.createAddress();
        return ResponseEntity.created(new URI("/address" + result.getAddress_id())).body(result);
    }

    @PutMapping("/updateAddress/{id}")
    ResponseEntity<Address> updateAddress(@PathVariable String id, @Valid @RequestBody Address address) {
        address.setAddress_id(id);
        log.info("Request to update group: {}", address);
        Address result = adminDatabase.updateAddress(address.getAddress_line_1(), address.getAddress_line_2(), address.getAddress_line_3(), address.getPostal_code(),address.getCity(), address.getCountry(), address.getAddress_id());
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable String id) {
        log.info("Request to delete group: {}", id);
        adminDatabase.deleteAddress();
        return ResponseEntity.ok().build();
    }

}