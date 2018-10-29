package no.experis.FootballStats.Admin;

import no.experis.FootballStats.Admin.Models.Address;
import no.experis.FootballStats.Admin.Models.Player;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    // TODO: **** Buisness Logic ****

    private AdminDatabaseManager adminDbManager = new AdminDatabaseManager();

    public void createAddress(Address address){
        int id = adminDbManager.createAddress(address.getAddress_line_1(), address.getAddress_line_2(), address.getAddress_line_3(), address.getPostal_code(),address.getCity(), address.getCountry());
        adminDbManager.createLocation(address.getName(), address.getDescription(), id);
    }

    public void deleteAddress(String address_id){
        adminDbManager.deleteAddress(address_id);
    }

    public void createPlayer(Player player){
        int id = adminDbManager.createPerson(player.getFirst_name(), player.getLast_name(), player.getDate_of_birth(), player.getAddress_id());
        adminDbManager.createPlayer(player.getNormal_position(), player.getNumber(), id, player.getTeam_id());
    }

    public void updatePlayer(Player player){
        int id = adminDbManager.updatePerson(player.getFirst_name(), player.getLast_name(), player.getDate_of_birth(), player.getAddress_id());
        adminDbManager.updatePlayer(player.getNormal_position(), player.getNumber(), id, player.getTeam_id());

    }

    /*
      private String player_id;
    private String normal_position;
    private String number;
    private String team_id;
     */

}