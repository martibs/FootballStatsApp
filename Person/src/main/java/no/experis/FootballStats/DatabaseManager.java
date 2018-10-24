package no.experis.FootballStats;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    private final String DB_HOST = "case1234.cqjagjopuiru.eu-central-1.rds.amazonaws.com";
    private final String DB_PORT = "5432";
    private final String DB_USER = "case1234";
    private final String DB_PASSWD = "case1234";
    private final String DB_NAME = "caseDB";
    private final String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    private Connection conn = null;

    private String id;
    private String firstname;
    private String lastname;
    private String date;
    private String addressid;


    // TODO: CHECK CONNECTION POOLING!

    public Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
        } catch (ClassNotFoundException | SQLException ex) {
            //log.error(ex);
            System.out.println(ex.getMessage());
        }
        return conn;
    }

    public ArrayList<Player> getPlayers() {
        String sql = "SELECT * FROM PLAYER INNER JOIN PERSON ON PERSON.PERSON_ID = PLAYER.PERSON_ID";

        Player tempPlayer = null;
        ArrayList<Player> tempPlayersList = new ArrayList<Player>();
        String player_id;
        String normal_position;
        String number;
        String team_id;

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                id = Integer.toString(rs.getInt("PERSON_ID"));
                firstname = rs.getString("FIRST_NAME");
                lastname = rs.getString("LAST_NAME");
                date = rs.getString("DATE_OF_BIRTH");
                addressid = Integer.toString(rs.getInt("ADDRESS_ID"));
                player_id = Integer.toString(rs.getInt("PLAYER_ID"));
                normal_position = rs.getString("NORMAL_POSITION");
                number = rs.getString("NUMBER");
                team_id = Integer.toString(rs.getInt("TEAM_ID"));

                tempPlayer = new Player(id,firstname,lastname,date,addressid, player_id, normal_position, number, team_id);
                tempPlayersList.add(tempPlayer);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempPlayersList;
    }

    public ArrayList<Coach> getCoaches() {
        String sql = "SELECT * FROM COACH INNER JOIN PERSON ON PERSON.PERSON_ID = COACH.PERSON_ID";

        Coach tempCoach = null;
        ArrayList<Coach> tempCoachList = new ArrayList<Coach>();
        String coachid;

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                id = Integer.toString(rs.getInt("PERSON_ID"));
                firstname = rs.getString("FIRST_NAME");
                lastname = rs.getString("LAST_NAME");
                date = rs.getString("DATE_OF_BIRTH");
                addressid = Integer.toString(rs.getInt("ADDRESS_ID"));
                coachid = Integer.toString(rs.getInt("COACH_ID"));

                tempCoach = new Coach(id,firstname,lastname,date,addressid, coachid);
                tempCoachList.add(tempCoach);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tempCoachList;
    }

    public ArrayList<Owner> getOwners() {
        String sql = "SELECT * FROM OWNER INNER JOIN PERSON ON PERSON.PERSON_ID = OWNER.PERSON_ID";

        Owner tempOwner = null;
        ArrayList<Owner> tempOwnerList = new ArrayList<Owner>();

        String ownerid;

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                id = Integer.toString(rs.getInt("PERSON_ID"));
                firstname = rs.getString("FIRST_NAME");
                lastname = rs.getString("LAST_NAME");
                date = rs.getString("DATE_OF_BIRTH");
                addressid = Integer.toString(rs.getInt("ADDRESS_ID"));
                ownerid = Integer.toString(rs.getInt("OWNER_ID"));

                tempOwner = new Owner(id,firstname,lastname,date,addressid, ownerid);
                tempOwnerList.add(tempOwner);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempOwnerList;
    }


    // TEST UPDATE STATEMENT
    public void updateTest() {
        // SQL statement for updating a table

        System.out.println("Started to update a table!");

        String sql = "UPDATE PERSON SET FIRST_NAME = 'GEIR' WHERE PERSON_ID = 3;";

        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("fin.");
    }

    // CREATES A NEW DATABASE
    public void createNewDatabase() {
        // SQL statement for creating a new table

        System.out.println("started to create a table");

        String sql = "DROP TABLE IF EXISTS MATCH_GOAL;\n" +
                "DROP TABLE IF EXISTS MATCH_POSITION;\n" +
                "DROP TABLE IF EXISTS PLAYER;\n" +
                "DROP TABLE IF EXISTS RESULT;\n" +
                "DROP TABLE IF EXISTS MATCH;\n" +
                "DROP TABLE IF EXISTS TEAM;\n" +
                "DROP TABLE IF EXISTS COACH;\n" +
                "DROP TABLE IF EXISTS OWNER;\n" +
                "DROP TABLE IF EXISTS CONTACT;\n" +
                "DROP TABLE IF EXISTS GOAL_TYPE;\n" +
                "DROP TABLE IF EXISTS PERSON;\n" +
                "DROP TABLE IF EXISTS ASSOCIATION;\n" +
                "DROP TABLE IF EXISTS LOCATION;\n" +
                "DROP TABLE IF EXISTS SEASON;\n" +
                "DROP TABLE IF EXISTS ADDRESS;\n" +
                "\n" +
                "\n" +
                "CREATE TABLE ADDRESS\n" +
                "(\n" +
                "  address_id SERIAL NOT NULL,\n" +
                "  address_line_1 VARCHAR(64) NOT NULL,\n" +
                "  address_line_2 VARCHAR(64),\n" +
                "  postal_code VARCHAR(8) NOT NULL,\n" +
                "  city VARCHAR(64) NOT NULL,\n" +
                "  country VARCHAR(64) NOT NULL,\n" +
                "  address_line_3 VARCHAR(64),\n" +
                "  PRIMARY KEY (address_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE SEASON\n" +
                "(\n" +
                "  season_id SERIAL NOT NULL,\n" +
                "  start_date DATE NOT NULL,\n" +
                "  end_date DATE NOT NULL,\n" +
                "  name VARCHAR(64) NOT NULL,\n" +
                "  description VARCHAR(64),\n" +
                "  PRIMARY KEY (season_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE LOCATION\n" +
                "(\n" +
                "  location_id SERIAL NOT NULL,\n" +
                "  name VARCHAR(64) NOT NULL,\n" +
                "  description VARCHAR(64),\n" +
                "  address_id integer NOT NULL,\n" +
                "  PRIMARY KEY (location_id),\n" +
                "  FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE ASSOCIATION\n" +
                "(\n" +
                "  association_id SERIAL NOT NULL,\n" +
                "  name VARCHAR(64) NOT NULL,\n" +
                "  description VARCHAR(64) NOT NULL,\n" +
                "  PRIMARY KEY (association_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE PERSON\n" +
                "(\n" +
                "  person_id SERIAL NOT NULL,\n" +
                "  first_name VARCHAR(64) NOT NULL,\n" +
                "  last_name VARCHAR(64) NOT NULL,\n" +
                "  date_of_birth DATE NOT NULL,\n" +
                "  address_id integer,\n" +
                "  PRIMARY KEY (person_id),\n" +
                "  FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE GOAL_TYPE\n" +
                "(\n" +
                "  goal_type_id SERIAL NOT NULL,\n" +
                "  type VARCHAR(64) NOT NULL,\n" +
                "  PRIMARY KEY (goal_type_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE CONTACT\n" +
                "(\n" +
                "  contact_id SERIAL NOT NULL,\n" +
                "  contact_type VARCHAR(64) NOT NULL,\n" +
                "  contact_detail VARCHAR(64) NOT NULL,\n" +
                "  person_id INT NOT NULL,\n" +
                "  PRIMARY KEY (contact_id),\n" +
                "  FOREIGN KEY (person_id) REFERENCES PERSON(person_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE OWNER\n" +
                "(\n" +
                "  owner_id SERIAL NOT NULL,\n" +
                "  person_id INT NOT NULL,\n" +
                "  PRIMARY KEY (owner_id),\n" +
                "  FOREIGN KEY (person_id) REFERENCES PERSON(person_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE COACH\n" +
                "(\n" +
                "  coach_id SERIAL NOT NULL,\n" +
                "  person_id INT NOT NULL,\n" +
                "  PRIMARY KEY (coach_id),\n" +
                "  FOREIGN KEY (person_id) REFERENCES PERSON(person_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE TEAM\n" +
                "(\n" +
                "  team_id SERIAL NOT NULL,\n" +
                "  owner_id INT NOT NULL,\n" +
                "  association_id INT NOT NULL,\n" +
                "  coach_id INT NOT NULL,\n" +
                "  location_id INT NOT NULL,\n" +
                "  PRIMARY KEY (team_id),\n" +
                "  FOREIGN KEY (owner_id) REFERENCES OWNER(owner_id),\n" +
                "  FOREIGN KEY (association_id) REFERENCES ASSOCIATION(association_id),\n" +
                "  FOREIGN KEY (coach_id) REFERENCES COACH(coach_id),\n" +
                "  FOREIGN KEY (location_id) REFERENCES LOCATION(location_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE MATCH\n" +
                "(\n" +
                "  match_id SERIAL NOT NULL,\n" +
                "  match_date DATE NOT NULL,\n" +
                "  season_id INT NOT NULL,\n" +
                "  location_id INT NOT NULL,\n" +
                "  home_team_id INT NOT NULL,\n" +
                "  away_team_id INT NOT NULL,\n" +
                "  PRIMARY KEY (match_id),\n" +
                "  FOREIGN KEY (season_id) REFERENCES SEASON(season_id),\n" +
                "  FOREIGN KEY (location_id) REFERENCES LOCATION(location_id),\n" +
                "  FOREIGN KEY (home_team_id) REFERENCES TEAM(team_id),\n" +
                "  FOREIGN KEY (away_team_id) REFERENCES TEAM(team_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE RESULT\n" +
                "(\n" +
                "  score INT NOT NULL,\n" +
                "  result VARCHAR(4) NOT NULL,\n" +
                "  match_id INT NOT NULL,\n" +
                "  team_id INT NOT NULL,\n" +
                "  PRIMARY KEY (match_id,team_id),\n" +
                "  FOREIGN KEY (match_id) REFERENCES MATCH(match_id),\n" +
                "  FOREIGN KEY (team_id) REFERENCES TEAM(team_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE PLAYER\n" +
                "(\n" +
                "  player_id SERIAL NOT NULL,\n" +
                "  normal_position VARCHAR(64),\n" +
                "  number VARCHAR(8),\n" +
                "  person_id INT NOT NULL,\n" +
                "  team_id INT NOT NULL,\n" +
                "  PRIMARY KEY (player_id),\n" +
                "  FOREIGN KEY (person_id) REFERENCES PERSON(person_id),\n" +
                "  FOREIGN KEY (team_id) REFERENCES TEAM(team_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE MATCH_POSITION\n" +
                "(\n" +
                "  position VARCHAR(64),\n" +
                "  player_id INT NOT NULL,\n" +
                "  match_id INT NOT NULL,\n" +
                "  PRIMARY KEY (player_id, match_id),\n" +
                "  FOREIGN KEY (player_id) REFERENCES PLAYER(player_id),\n" +
                "  FOREIGN KEY (match_id) REFERENCES MATCH(match_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE MATCH_GOAL\n" +
                "(\n" +
                "  goal_id SERIAL NOT NULL,\n" +
                "  description VARCHAR(64),\n" +
                "  goal_type_id INT NOT NULL,\n" +
                "  match_id INT NOT NULL,\n" +
                "  player_id INT NOT NULL,\n" +
                "  PRIMARY KEY (goal_id),\n" +
                "  FOREIGN KEY (goal_type_id) REFERENCES GOAL_TYPE(goal_type_id),\n" +
                "  FOREIGN KEY (match_id) REFERENCES MATCH(match_id),\n" +
                "  FOREIGN KEY (player_id) REFERENCES PLAYER(player_id)\n" +
                ");\n" +
                "\n" +
                "-- INSERT ADDRESS\n" +
                "INSERT INTO address(address_line_1,address_line_2,address_line_3,postal_code,city,country) VALUES('Granfaret 32',NULL,NULL,'1405','Langhus','Norway');\n" +
                "INSERT INTO address(address_line_1,address_line_2,address_line_3,postal_code,city,country) VALUES('Aasveien 33',NULL,NULL,'1430','Aas','Norway');\n" +
                "INSERT INTO address(address_line_1,address_line_2,address_line_3,postal_code,city,country) VALUES('Skiveien 34',NULL,NULL,'1400','Ski','Norway');\n" +
                "INSERT INTO address(address_line_1,address_line_2,address_line_3,postal_code,city,country) VALUES('Bergenveien 35',NULL,NULL,'1300','Bergen','Norway');\n" +
                "\n" +
                "\n" +
                "-- INSERT SEASON\n" +
                "INSERT INTO season(start_date,end_date,name,description) VALUES ('2018-01-01','2018-12-31','Season1','First Season');\n" +
                "INSERT INTO season(start_date,end_date,name,description) VALUES ('2019-01-01','2019-12-31','Season2','Second Season');\n" +
                "INSERT INTO season(start_date,end_date,name,description) VALUES ('2020-01-01','2020-12-31','Season3','Third Season');\n" +
                "\n" +
                "\n" +
                "-- INSERT LOCATION\n" +
                "INSERT INTO location(name,description,address_id) VALUES ('Langhus','Description of Langhus...',1);\n" +
                "INSERT INTO location(name,description,address_id) VALUES ('Aas','Description of Aas...',2);\n" +
                "INSERT INTO location(name,description,address_id) VALUES ('Ski','Description of Ski...',3);\n" +
                "INSERT INTO location(name,description,address_id) VALUES ('Bergen','Description of Bergen...',4);\n" +
                "\n" +
                "\n" +
                "\n" +
                "-- INSERT ASSOCIATION\n" +
                "INSERT INTO association(name,description) VALUES ('Manchester City','Description of Association1...');\n" +
                "INSERT INTO association(name,description) VALUES ('Manchester United','Description of Association2...');\n" +
                "INSERT INTO association(name,description) VALUES ('Liverpool','Description of Association3...');\n" +
                "INSERT INTO association(name,description) VALUES ('Chelsea','Description of Association4...');\n" +
                "\n" +
                "\n" +
                "-- INSERT PERSON\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES ('Gabriel','Aunan','1991-03-26',1);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES ('Martin','Martinsen','1993-05-16',2);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES ('Thor','Thordenlund','1991-03-26',3);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES ('Harald','Hudini','1989-02-08',4);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES ('Gunnar','Gunnarsen','1989-02-08',1);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES ('Svein','Svendsen','1989-02-08',2);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES ('Gjert','Gjertsen','1989-02-08',3);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES ('Mads','Madsen','1989-02-08',4);\n" +
                "\n" +
                "-- INSERT GOAL_TYPE\n" +
                "INSERT INTO goal_type(type) VALUES ('Penalty');\n" +
                "INSERT INTO goal_type(type) VALUES ('Free kick');\n" +
                "INSERT INTO goal_type(type) VALUES ('Corner');\n" +
                "\n" +
                "-- INSERT CONTACT\n" +
                "INSERT INTO contact(contact_type,contact_detail, person_id) VALUES ('Cell','98047957',1);\n" +
                "INSERT INTO contact(contact_type,contact_detail, person_id) VALUES ('Cell','98076487',2);\n" +
                "INSERT INTO contact(contact_type,contact_detail, person_id) VALUES ('Cell','98968473',3);\n" +
                "\n" +
                "-- INSERT OWNER\n" +
                "INSERT INTO owner(person_id) VALUES (1);\n" +
                "INSERT INTO owner(person_id) VALUES (2);\n" +
                "INSERT INTO owner(person_id) VALUES (3);\n" +
                "\n" +
                "-- INSERT COACH\n" +
                "INSERT INTO coach(person_id) VALUES (1);\n" +
                "INSERT INTO coach(person_id) VALUES (2);\n" +
                "INSERT INTO coach(person_id) VALUES (3);\n" +
                "\n" +
                "-- INSERT TEAM\n" +
                "INSERT INTO team(owner_id,association_id,coach_id,location_id) VALUES (1,1,1,1);\n" +
                "INSERT INTO team(owner_id,association_id,coach_id,location_id) VALUES (2,2,2,2);\n" +
                "INSERT INTO team(owner_id,association_id,coach_id,location_id) VALUES (3,3,3,3);\n" +
                "\n" +
                "-- INESRT MACTCH\n" +
                "INSERT INTO match(match_date,season_id,location_id,home_team_id,away_team_id) VALUES ('2018-06-01',1,1,1,2);\n" +
                "INSERT INTO match(match_date,season_id,location_id,home_team_id,away_team_id) VALUES ('2018-06-01',1,2,2,3);\n" +
                "INSERT INTO match(match_date,season_id,location_id,home_team_id,away_team_id) VALUES ('2018-06-01',1,3,3,1);\n" +
                "\n" +
                "INSERT INTO match(match_date,season_id,location_id,home_team_id,away_team_id) VALUES ('2019-06-01',2,1,1,2);\n" +
                "INSERT INTO match(match_date,season_id,location_id,home_team_id,away_team_id) VALUES ('2019-06-01',2,2,2,3);\n" +
                "INSERT INTO match(match_date,season_id,location_id,home_team_id,away_team_id) VALUES ('2019-06-01',2,3,3,1);\n" +
                "\n" +
                "-- INSERT RESULT\n" +
                "INSERT INTO result(score,result,match_id,team_id) VALUES (3,'Win',1,1);\n" +
                "INSERT INTO result(score,result,match_id,team_id) VALUES (2,'Loss',1,2);\n" +
                "\n" +
                "INSERT INTO result(score,result,match_id,team_id) VALUES (2,'Draw',2,2);\n" +
                "INSERT INTO result(score,result,match_id,team_id) VALUES (2,'Draw',2,3);\n" +
                "\n" +
                "INSERT INTO result(score,result,match_id,team_id) VALUES (3,'Win',3,1);\n" +
                "INSERT INTO result(score,result,match_id,team_id) VALUES (1,'Loss',3,3);\n" +
                "\n" +
                "-- INSERT PLAYER\n" +
                "INSERT INTO Player(normal_position,number,person_id,team_id) VALUES ('Attack','1',1,1);\n" +
                "INSERT INTO Player(normal_position,number,person_id,team_id) VALUES ('Defence','2',2,2);\n" +
                "INSERT INTO Player(normal_position,number,person_id,team_id) VALUES ('Center','3',3,3);\n" +
                "INSERT INTO Player(normal_position,number,person_id,team_id) VALUES ('Attack','9',4,3);\n" +
                "INSERT INTO Player(normal_position,number,person_id,team_id) VALUES ('Attack','9',5,2);\n" +
                "INSERT INTO Player(normal_position,number,person_id,team_id) VALUES ('Center','5',6,2);\n" +
                "INSERT INTO Player(normal_position,number,person_id,team_id) VALUES ('Center','6',7,2);\n" +
                "\n" +
                "-- INSERT MATCH_POSITION\n" +
                "INSERT INTO MATCH_POSITION(position,player_id,match_id) VALUES ('Attack',1,1);\n" +
                "INSERT INTO MATCH_POSITION(position,player_id,match_id) VALUES ('Attack',2,1);\n" +
                "\n" +
                "INSERT INTO MATCH_POSITION(position,player_id,match_id) VALUES ('Defence',2,2);\n" +
                "INSERT INTO MATCH_POSITION(position,player_id,match_id) VALUES ('Attack',3,2);\n" +
                "\n" +
                "INSERT INTO MATCH_POSITION(position,player_id,match_id) VALUES ('Center',3,3);\n" +
                "INSERT INTO MATCH_POSITION(position,player_id,match_id) VALUES ('Attack',1,3);\n" +
                "\n" +
                "-- INSERT MATCH_GOAL\n" +
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Corner goal',3,1,1);\n" +
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Free-kick goal',2,1,1);\n" +
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Penalty goal',1,1,1);\n" +
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Corner goal',3,1,2);\n" +
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Free-kick goal',2,1,2);\n" +
                "\n" +
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Corner goal',3,2,2);\n" +
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Free-kick goal',2,2,2);\n" +
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Penalty goal',1,2,3);\n" +
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Free-kick goal',2,2,3);\n" +
                "\n" +
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Corner goal',3,3,1);\n" +
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Free-kick goal',2,3,1);\n" +
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Corner goal',3,3,1);\n" +
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Free-kick goal',2,3,3);\n";

                try (Connection conn = this.connect();
                     Statement stmt = conn.createStatement()) {
                    // creates new tables
                    stmt.execute(sql);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("fin.");
    }

}
