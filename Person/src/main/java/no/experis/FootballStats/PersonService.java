package no.experis.FootballStats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    public List<Player> displayAllPersons(){
        // String sql = "SELECT * FROM CARS";
        //List<Person> people = jtm.query(sql, new BeanPropertyRowMapper(Car.class));

        Player martin = new Player("1", "Martin", "Sundfor", "12321", "1", "2", "striker", "9", "5");

        ArrayList<Player> people = new ArrayList<Player>();

        people.add(martin);
        return people;
    }

}
