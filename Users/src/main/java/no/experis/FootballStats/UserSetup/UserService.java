package no.experis.FootballStats.UserSetup;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    // TODO: **** Buisness Logic ****
    private DatabaseManager dbManager = new DatabaseManager();

    public void registerUser(){
        if(validateUserInput()){
            dbManager.insertUserInDB();
        }
        else{
            // TODO: Handle errors
            System.out.println("ERROR, UserSetup input was incorrect!");
        }
    }


    public boolean validateUserInput(){
        if(true){
            return true;
        }else{
            return false;
        }
    }

}