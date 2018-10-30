package no.experis.FootballStats.Admin;

import no.experis.FootballStats.Admin.Models.Address;
import no.experis.FootballStats.Admin.Models.Coach;
import no.experis.FootballStats.Admin.Models.Owner;
import no.experis.FootballStats.Admin.Models.Player;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminDatabaseManager adminDbManager = new AdminDatabaseManager();


    // ADDRESS

    public void createAddress(Address address){
        int id = adminDbManager.createAddress(address.getAddress_line_1(), address.getAddress_line_2(), address.getAddress_line_3(), address.getPostal_code(),address.getCity(), address.getCountry());
        adminDbManager.createLocation(address.getName(), address.getDescription(), id);
    }

    public void updateAddress(Address address, int addressId){
        adminDbManager.updateAddress(address.getAddress_line_1(), address.getAddress_line_2(), address.getAddress_line_3(), address.getPostal_code(),address.getCity(), address.getCountry(), addressId);
        adminDbManager.updateLocation(address.getName(), address.getDescription(), address.getLocation_id());
    }

    public void deleteAddress(String address_id){
        adminDbManager.deleteAddress(address_id);
    }

    // PERSON

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
        int id = adminDbManager.updatePerson(player.getFirst_name(), player.getLast_name(), player.getDate_of_birth(), player.getAddress_id());
        adminDbManager.updatePlayer(player.getNormal_position(), player.getNumber(), id, player.getTeam_id());
    }

    public void updateCoach(Coach coach){
        int id = adminDbManager.updatePerson(coach.getFirst_name(), coach.getLast_name(), coach.getDate_of_birth(), coach.getAddress_id());
        adminDbManager.updateCoach(id);
    }

    public void updateOwner(Owner owner){
        int id = adminDbManager.updatePerson(owner.getFirst_name(), owner.getLast_name(), owner.getDate_of_birth(), owner.getAddress_id());
        adminDbManager.updateOwner(id);
    }


    // GOAL



    // MATCH



    // RESULT



    // SEASON



    // TEAM




}