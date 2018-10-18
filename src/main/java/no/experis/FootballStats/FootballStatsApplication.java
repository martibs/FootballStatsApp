package no.experis.FootballStats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class FootballStatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballStatsApplication.class, args);
		DatabaseManager dbManager = new DatabaseManager();
/*
		ArrayList<Person> listOfPeople = dbManager.getAllPeople();
		for(Person person : listOfPeople){
			System.out.println(person.toString());
		}
*/
	}

}