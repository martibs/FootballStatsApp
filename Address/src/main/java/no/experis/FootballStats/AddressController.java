package no.experis.FootballStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AddressController {

    private AddressService addressService = new AddressService();

    @GetMapping("/showAddresses")
    public List showAddresses() {
        List<Address> addresses = addressService.displayAllAddresses();
        return addresses;
    }

    @GetMapping("/showOneAddress")
    public Address showAddress(){
        String addressid = "1";      // TODO: Change the var to proper springboot GET variable
        Address address = addressService.displayOneAddress(addressid);
        return address;
    }

}