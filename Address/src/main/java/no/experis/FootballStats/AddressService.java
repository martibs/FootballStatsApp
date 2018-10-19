package no.experis.FootballStats;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private DatabaseManager dbManager = new DatabaseManager();

    // Players
    public List<Address> displayAllAddresses(){
        ArrayList<Address> addresses = new ArrayList<Address>();

        addresses.addAll(dbManager.getAddresses());

        return addresses;
    }


    public Address displayOneAddress(String address_id){
        ArrayList<Address> addresses = new ArrayList<Address>();
        addresses.addAll(dbManager.getAddresses());

        for(Address address : addresses){
            if(address.getAddress_id().equals(address_id)){
                return address;
            }
        }
        return null;
    }

}
