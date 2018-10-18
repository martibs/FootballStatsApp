package no.experis.FootballStats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    public List<Person> displayAllPersons(){
        // String sql = "SELECT * FROM CARS";
        //List<Person> people = jtm.query(sql, new BeanPropertyRowMapper(Car.class));

        Person martin = new Person(1, "Martin", "Sundfor", "12321", 1 );
        Person gabriel = new Person(2, "Gabriel", "Aunan", "12321", 2 );

        ArrayList<Person> people = new ArrayList<Person>();

        people.add(martin);
        people.add(gabriel);

        return people;
    }

}
