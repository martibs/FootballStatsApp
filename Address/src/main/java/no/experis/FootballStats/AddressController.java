package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AddressController {

    private AddressService addressService = new AddressService();

    @GetMapping("/showAddresses")
    public List showAddresses() {
        return addressService.displayAllAddresses();
    }

    @GetMapping("/showOneAddress/{someID}")
    public Address showAddress(@PathVariable(value="someID") String id){
        return addressService.displayOneAddress(id);
    }
}