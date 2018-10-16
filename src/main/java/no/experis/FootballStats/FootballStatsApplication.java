package no.experis.FootballStats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;

@SpringBootApplication
public class FootballStatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballStatsApplication.class, args);
		DatabaseManager dbManager = new DatabaseManager();
		String name = dbManager.findPerson();
		System.out.println(name);
	}

}