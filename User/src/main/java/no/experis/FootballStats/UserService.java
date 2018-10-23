package no.experis.FootballStats;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    // TODO: **** Buisness Logic ****

    private DatabaseManager dbManager = new DatabaseManager();

    public void registerUser(){
        if(validateUserInput()){
            dbManager.insertUserInDB();
        }else{
            // TODO: Handle errors
            System.out.println("ERROR, User input was incorrect!");
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