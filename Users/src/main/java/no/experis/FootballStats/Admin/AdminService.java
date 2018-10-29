package no.experis.FootballStats.Admin;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    // TODO: **** Buisness Logic ****

    private AdminDatabaseManager adminDbManager = new AdminDatabaseManager();

/*
    // Addresses
    public List<Address> displayAllAddresses(){
        ArrayList<Address> addresses = new ArrayList<Address>();

        addresses.addAll(adminDbManager.getAddresses());
        return addresses;
    }

    public Address displayOneAddress(String address_id){
        ArrayList<Address> addresses = new ArrayList<Address>();
        addresses.addAll(adminDbManager.getAddresses());

        for(Address address : addresses){
            if(address.getAddress_id().equals(address_id)){
                return address;
            }
        }
        return null;
    }
*/

    public void createAddress(Address address){
        int id = adminDbManager.createAddress(address.getAddress_line_1(), address.getAddress_line_2(), address.getAddress_line_3(), address.getPostal_code(),address.getCity(), address.getCountry());
        System.out.println("ID is: " + id);
        adminDbManager.createLocation(address.getName(), address.getDescription(), id);
    }


    public void deleteAddress(String address_id){
        adminDbManager.deleteAddress(address_id);
    }
}