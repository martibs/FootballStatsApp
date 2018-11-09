package no.experis.FootballStats.UserSetup;

import no.experis.FootballStats.Admin.Models.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private DatabaseManager dbManager = new DatabaseManager();


    // USER

    public List<User> displayUsers(){
        ArrayList<User> contacts = new ArrayList<User>();
        contacts.addAll(dbManager.getUsersFromDb());
        return contacts;
    }

    public User displayOneUser(String id){
        ArrayList<User> users = new ArrayList<User>();
        users.addAll(dbManager.getUsersFromDb());

        for(User user : users){
            if(user.getUserId().equals(id)){
                return user;
            }
        }
        return null;
    }

}