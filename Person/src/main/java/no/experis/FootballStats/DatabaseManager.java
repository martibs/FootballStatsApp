package no.experis.FootballStats;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    private final String DB_HOST = "ec2-46-51-184-229.eu-west-1.compute.amazonaws.com";
    private final String DB_PORT = "5432";
    private final String DB_USER = "uvmyugpkrtubxx";
    private final String DB_PASSWD = "a42ebfe205e754d8b170f120ab30d5679bf64a324b80b2bc429c3e2e90f9f353";
    private final String DB_NAME = "d5togjfivbt4tr";
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
        String player_image;

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
                player_image = rs.getString("player_image");

                tempPlayer = new Player(id,firstname,lastname,date,addressid, player_id, normal_position, number, team_id,player_image);
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


    public ArrayList<Person> getPersons() {
        String sql = "SELECT * FROM PERSON";

        Person tempPlayer = null;
        ArrayList<Person> tempPlayersList = new ArrayList<Person>();

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

                tempPlayer = new Person(id,firstname,lastname,date,addressid);
                tempPlayersList.add(tempPlayer);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempPlayersList;
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
                "DROP TABLE IF EXISTS news;\n" +
                "DROP TABLE IF EXISTS player_watchlist;\n" +
                "DROP TABLE IF EXISTS team_watchlist;\n" +
                "DROP TABLE IF EXISTS users;\n" +
                "DROP TABLE IF EXISTS admin;\n" +
                "\n" +
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
                "  address_id integer NOT NUll,\n" +
                "  PRIMARY KEY (location_id),\n" +
                "  FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id) MATCH SIMPLE\n" +
                "      ON DELETE SET NULL ON UPDATE CASCADE\n" +
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
                "  FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id) MATCH SIMPLE\n" +
                "      ON DELETE SET NULL ON UPDATE CASCADE\n" +
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
                "  FOREIGN KEY (person_id) REFERENCES PERSON(person_id) \n" +
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
                "  association_id INT NOT NULL,\n" +
                "  coach_id INT NOT NULL,\n" +
                "  owner_id INT NOT NULL,\n" +
                "  location_id INT NOT NULL,\n" +
                "  team_image VARCHAR(150) DEFAULT NULL,\n" +
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
                "  player_image VARCHAR(150) DEFAULT NULL,\n" +
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
                "CREATE TABLE news\n" +
                "(\n" +
                "  news_id SERIAL NOT NULL,\n" +
                "  news_string character varying(150) NOT NULL,\n" +
                "  team_id integer DEFAULT NULL,\n" +
                "  player_id integer DEFAULT NULL,\n" +
                "  CONSTRAINT news_pkey PRIMARY KEY (news_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE users\n" +
                "(\n" +
                "  user_id SERIAL NOT NULL,\n" +
                "  email character varying(64) NOT NULL,\n" +
                "  password character varying(64) NOT NULL,\n" +
                "  CONSTRAINT users_pkey PRIMARY KEY (user_id),\n" +
                "  CONSTRAINT users_email_key UNIQUE (email)\n" +
                ");\n" +
                " CREATE TABLE player_watchlist\n" +
                "(\n" +
                "  player_watch_id integer NOT NULL,\n" +
                "  user_id integer NOT NULL,\n" +
                "  CONSTRAINT player_user_pkey PRIMARY KEY (player_watch_id,user_id),\n" +
                "  CONSTRAINT player_user_fkey FOREIGN KEY(user_id) REFERENCES users(user_id)\n" +
                ");\n" +
                " CREATE TABLE team_watchlist\n" +
                "(\n" +
                "  team_watch_id integer NOT NULL,\n" +
                "  user_id integer NOT NULL,\n" +
                "  CONSTRAINT team_user_pkey PRIMARY KEY (team_watch_id,user_id),\n" +
                "  CONSTRAINT team_user_fkey FOREIGN KEY(user_id) REFERENCES users(user_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE admin\n" +
                "(\n" +
                "  user_id SERIAL NOT NULL,\n" +
                "  email character varying(64) NOT NULL,\n" +
                "  password character varying(64) NOT NULL,\n" +
                "  CONSTRAINT admin_pkey PRIMARY KEY (user_id),\n" +
                "  CONSTRAINT admin_email_key UNIQUE (email)\n" +
                ");\n" +
                "\n" +
                "-- INSERT ADDRESS\n" +
                "\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('713 Tony Place', '41 Brickson Park Drive', '3518 Walton Street', '353508', 'Temryuk', 'Russia');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('4 Hoffman Center', null, null, '4105', 'Noveleta', 'Philippines');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('9 Eagan Terrace', null, null, '32505', 'Pensacola', 'United States');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('5 Main Junction', null, null, '54673', 'Bryukhovychi', 'Ukraine');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('969 Arkansas Trail', '616 Maryland Crossing', null, '49010', 'Angers', 'France');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('8935 Continental Junction', null, null, '85729', 'Temanjang', 'Indonesia');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('87 Lotheville Point', null, null, '10294', 'Handan', 'China');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('098 Nancy Circle', '90 Corben Drive', null, '902311', 'Haebaru', 'Japan');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('1 Stone Corner Trail', null, null, '404436', 'Surovikino', 'Russia');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('16 Thompson Court', '06518 Sheridan Junction', '02 Loeprich Drive', '493005', 'Arão', 'Portugal');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('18 Forster Hill', '8 Veith Alley', null, '56342', 'Ifakara', 'Tanzania');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('83652 Mandrake Lane', '22652 Boyd Terrace', null, '98634', 'Bungereng', 'Indonesia');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('3904 Main Hill', null, '428 Stang Road', '132 30', 'Saltsjö-Boo', 'Sweden');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('0168 Kim Place', null, null, '43254', 'Krzyżowice', 'Poland');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('30570 Prairie Rose Avenue', '5146 Mitchell Pass', null, '03234', 'Khulo', 'Georgia');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('68 Clove Drive', null, null, '90958', 'Shanghu', 'China');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('8 Macpherson Trail', '185 Dunning Hill', '73460 North Parkway', '43465', 'Beni Khiar', 'Tunisia');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('176 Heffernan Parkway', '99 Caliangt Trail', null, '45467', 'Paojan', 'Indonesia');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('362 Thierer Drive', null, null, '5929', 'Hernando', 'Argentina');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('91 Browning Way', '39027 Pine View Place', null, '509147', 'Kakamigahara', 'Japan');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('162 Mosinee Avenue', null, null, '43211', 'Piasek', 'Poland');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('601 Cottonwood Park', null, '09262 Thompson Lane', '4634', 'Jujur', 'Indonesia');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('00186 Carpenter Point', null, null, '42575', 'Strzyżowice', 'Poland');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('6 Rowland Plaza', '18 Westend Place', null, '2364', 'Purabaya', 'Indonesia');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('041 Eastwood Lane', null, null, '8716', 'Adtugan', 'Philippines');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('8354 Trailsway Trail', null, '35549 High Crossing Parkway', '23463', 'Campechuela', 'Cuba');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('03 Little Fleur Trail', null, null, '58028', 'Nevers', 'France');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('45 Summerview Court', null, null, '48372', 'Al Quşayr', 'Egypt');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('87058 International Park', '1228 Charing Cross Parkway', null, '75110', 'Samut Songkhram', 'Thailand');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('6659 6th Point', '60369 Stuart Avenue', null, '69649', 'Caluire-et-Cuire', 'France');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('0001 Stephen Place', null, null, '98471', 'Governor’s Harbour', 'Bahamas');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('39913 Starling Crossing', '98 Gale Avenue', null, '91735', 'Uitiuhtuan', 'Indonesia');\n" +
                "insert into address (address_line_1, address_line_2, address_line_3, postal_code, city, country) values ('36 Oneill Place', null, '530 Mosinee Junction', '56722', 'Sambonggede', 'Indonesia');\n" +
                "\n" +
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
                "insert into location (name, description, address_id) values ('Granby', 'id ornare imperdiet sapien urna', 1);\n" +
                "insert into location (name, description, address_id) values ('Valley Edge', 'semper rutrum nulla nunc purus phasellus in', 2);\n" +
                "insert into location (name, description, address_id) values ('Brickson Park', null, 3);\n" +
                "insert into location (name, description, address_id) values ('Artisan', 'non mauris morbi non lectus', 4);\n" +
                "insert into location (name, description, address_id) values ('Walton', 'tempus vel pede morbi porttitor', 5);\n" +
                "insert into location (name, description, address_id) values ('Onsgard', 'porttitor id consequat in consequat', 6);\n" +
                "insert into location (name, description, address_id) values ('Carpenter', 'diam nam tristique tortor eu pede', 7);\n" +
                "insert into location (name, description, address_id) values ('Fair Oaks', 'odio elementum eu interdum eu', 8);\n" +
                "insert into location (name, description, address_id) values ('Hallows', 'nisi eu orci mauris lacinia sapien quis', 9);\n" +
                "insert into location (name, description, address_id) values ('Schurz', 'eros vestibulum ac est lacinia nisi', 10);\n" +
                "insert into location (name, description, address_id) values ('Leroy', 'vestibulum vestibulum ante ipsum primis in faucibus', 11);\n" +
                "insert into location (name, description, address_id) values ('Sullivan', null, 12);\n" +
                "insert into location (name, description, address_id) values ('Briar Crest', 'praesent id massa id nisl', 13);\n" +
                "insert into location (name, description, address_id) values ('Ruskin', null, 14);\n" +
                "insert into location (name, description, address_id) values ('Steensland', 'pharetra magna vestibulum aliquet ultrices erat tortor', 15);\n" +
                "insert into location (name, description, address_id) values ('Golden Leaf', null, 16);\n" +
                "insert into location (name, description, address_id) values ('Springview', 'proin leo odio porttitor id consequat in', 17);\n" +
                "insert into location (name, description, address_id) values ('Gale', 'vulputate elementum nullam varius nulla facilisi cras', 18);\n" +
                "insert into location (name, description, address_id) values ('Bellgrove', 'nibh in quis justo maecenas rhoncus', 19);\n" +
                "insert into location (name, description, address_id) values ('Beilfuss', 'pellentesque quisque porta volutpat erat quisque erat', 20);\n" +
                "insert into location (name, description, address_id) values ('Butterfield', null, 21);\n" +
                "insert into location (name, description, address_id) values ('Upham', 'integer a nibh in quis justo maecenas', 22);\n" +
                "insert into location (name, description, address_id) values ('Erie', null, 23);\n" +
                "insert into location (name, description, address_id) values ('Esch', null, 24);\n" +
                "insert into location (name, description, address_id) values ('Bayside', 'platea dictumst aliquam augue quam sollicitudin', 25);\n" +
                "insert into location (name, description, address_id) values ('Banding', null, 26);\n" +
                "insert into location (name, description, address_id) values ('Vera', 'ut massa quis augue luctus tincidunt', 27);\n" +
                "insert into location (name, description, address_id) values ('Cordelia', 'adipiscing lorem vitae mattis nibh ligula nec', 28);\n" +
                "insert into location (name, description, address_id) values ('Mockingbird', 'ut mauris eget massa tempor convallis', 29);\n" +
                "insert into location (name, description, address_id) values ('Del Sol', 'diam id ornare imperdiet sapien urna', 30);\n" +
                "insert into location (name, description, address_id) values ('8th', 'neque aenean auctor gravida sem', 31);\n" +
                "insert into location (name, description, address_id) values ('4th', 'nulla elit ac nulla sed vel enim', 32);\n" +
                "insert into location (name, description, address_id) values ('Old Shore', 'porta volutpat erat quisque erat eros viverra', 33);\n" +
                "\n" +
                "INSERT INTO location(name,description,address_id) VALUES ('Langhus','Description of Langhus...',34);\n" +
                "INSERT INTO location(name,description,address_id) VALUES ('Aas','Description of Aas...',35);\n" +
                "INSERT INTO location(name,description,address_id) VALUES ('Ski','Description of Ski...',36);\n" +
                "INSERT INTO location(name,description,address_id) VALUES ('Bergen','Description of Bergen...',37);\n" +
                "\n" +
                "\n" +
                "\n" +
                "-- INSERT ASSOCIATION\n" +
                "INSERT INTO association(name,description) VALUES ('Liverpool','Description of Association1...');\n" +
                "INSERT INTO association(name,description) VALUES ('Manchester United','Description of Association2...');\n" +
                "INSERT INTO association(name,description) VALUES ('Barcelona','Description of Association3...');\n" +
                "INSERT INTO association(name,description) VALUES ('Real Madrid','Description of Association4...');\n" +
                "\n" +
                "\n" +
                "-- INSERT PERSON\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (1, 'Addia', 'Southon', '1987-07-05');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (2, 'Nil', 'Asher', '2010-01-28');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (3, 'Ashil', 'Strover', '1997-01-03');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (4, 'Pinchas', 'Leahy', '1993-05-10');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (5, 'Julienne', 'Treffrey', '2012-10-24');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (6, 'Faythe', 'Burnham', '2009-12-20');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (7, 'Benetta', 'Kimbrough', '1977-07-01');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (8, 'Rhea', 'Cullingworth', '2010-09-23');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (9, 'Gilberte', 'Caldaro', '2007-06-11');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (10, 'Eimile', 'Shaddock', '2011-02-01');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (11, 'Milly', 'Waycot', '2017-04-28');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (12, 'Elianore', 'Lohan', '2007-12-27');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (13, 'Armando', 'Duligall', '1990-04-14');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (14, 'Laural', 'Wogan', '2000-01-31');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (15, 'Bryan', 'Cypler', '2015-05-14');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (16, 'Brier', 'Maseres', '2017-01-03');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (17, 'Rochette', 'Spelwood', '1992-07-09');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (18, 'Germain', 'Webling', '2012-08-06');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (19, 'Tobit', 'Marl', '1990-06-02');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (20, 'Alfie', 'Garatty', '1983-10-16');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (21, 'Anissa', 'Erskine Sandys', '1999-01-05');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (22, 'Geri', 'Mannooch', '1991-04-03');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (23, 'Marrilee', 'Lindores', '1982-08-22');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (24, 'Donelle', 'Timmermann', '1988-11-04');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (25, 'Everett', 'Abramowitz', '2007-10-04');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (26, 'Neall', 'Grigolon', '1993-06-07');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (27, 'Delia', 'Pregel', '2017-09-22');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (28, 'Billie', 'Jan', '2009-08-15');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (29, 'Kermie', 'Beatens', '2012-08-23');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (30, 'Rossy', 'Flintoffe', '1991-04-22');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (31, 'Arabela', 'Tourle', '2007-07-03');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (32, 'Damon', 'MacGilpatrick', '1989-01-22');\n" +
                "insert into person (address_id, first_name, last_name, date_of_birth) values (33, 'Jacinthe', 'Halfacre', '1985-04-23');\n" +
                "\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES ('Gabriel','Aunan','1991-03-26',1);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES ('Martin','Martinsen','1993-05-16',2);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES ('Thor','Thordenlund','1991-03-26',3);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES ('Harald','Hudini','1989-02-08',4);\n" +
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
                "insert into player ( normal_position, number, person_id, team_id) values ('Attack', '35', 2, 1);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Attack', '29', 1, 2);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Attack', '44', 3, 2);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Attack', '50', 4, 1);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Attack', '25', 5, 3);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Attack', '43', 6, 3);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Attack', '27', 7, 2);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Attack', '46', 8, 2);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Attack', '3', 9, 3);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Attack', '21', 10, 3);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Defence', '49', 11, 1);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Defence', '33', 12, 2);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Defence', '30', 13, 1);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Defence', '21', 14, 3);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Defence', '32', 15, 3);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Defence', '11', 16, 1);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Defence', '40', 17, 1);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Defence', '43', 18, 3);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Defence', '42', 19, 3);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Defence', '19', 20, 1);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Center', '48', 21, 2);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Center', '2', 22, 1);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Center', '15', 23, 2);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Keeper', '16', 24, 3);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Center', '6', 25, 1);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Center', '35', 26, 3);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Center', '27', 27, 1);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Center', '43', 28, 1);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Center', '12', 29, 1);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Center', '17', 30, 2);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Center', '14', 31, 1);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Keeper', '9', 32, 2);\n" +
                "insert into player ( normal_position, number, person_id, team_id) values ('Keeper', '2', 33, 1);\n" +
                "\n" +
                "INSERT INTO Player(normal_position,number,person_id,team_id) VALUES ('Attack','1',1,1);\n" +
                "INSERT INTO Player(normal_position,number,person_id,team_id) VALUES ('Defence','2',2,2);\n" +
                "INSERT INTO Player(normal_position,number,person_id,team_id) VALUES ('Center','3',3,3);\n" +
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
                "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES ('Free-kick goal',2,3,3);\n" +
                "\n" +
                "-- INSERT NEWS\n" +
                "insert into news (news_string) values('Tyrael scored a goal for Hells Angles');\n" +
                "insert into news (news_string) values('Voljin joined The Loa Football Club');\n" +
                "insert into news (news_string) values('Team Cyntex won their match ageinst the Ghuuns');\n" +
                "insert into news (news_string) values('Yin got a new coach, Yang');\n" +
                "insert into news (news_string) values('Lucio join Wall Riders');\n" +
                "\n" +
                "-- insert gab team\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES('Illidan','Stormrage','1991-03-26',10);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES('Jaina','Proudmoore','1989-12-26',10);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES('Sylvanas','Windrunner','1985-08-30',10);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES('Varok','Saurfang','1988-03-07',10);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES('Anduin','Wrynn','1991-01-01',10);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES('Varian','Wrynn','1986-11-21',10);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES('Malfurion','Stormrage','1990-10-26',10);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES('Tyrande','Whisperwind','1987-05-20',10);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES('Baine','Bloodhoof','1988-03-26',10);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES('Genn','Graymane','1989-04-06',10);\n" +
                "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES('Thrall','Thrall','1981-03-16',10);\n" +
                "\n" +
                "INSERT INTO coach(person_id) VALUES (48);\n" +
                "\n" +
                "INSERT INTO owner(person_id) VALUES (48);\n" +
                "\n" +
                "INSERT INTO association(name,description) VALUES ('WOW','A team of creatures from all over Azeroth');\n" +
                "\n" +
                "INSERT INTO team(owner_id,association_id,coach_id,location_id,team_image) VALUES (4,5,4,10,'https://upload.wikimedia.org/wikipedia/commons/e/eb/WoW_icon.svg');\n" +
                "\n" +
                "insert into player ( normal_position, number, person_id, team_id,player_image) values ('Attack', '5', 38, 4,'https://d1u5p3l4wpay3k.cloudfront.net/wowpedia/e/e0/Illidan_the_Betrayer.jpg?version=ca1a497f686d4e0fb9ecf6ab8b9005cf');\n" +
                "\n" +
                "insert into player ( normal_position, number, person_id, team_id,player_image) values ('Attack', '29', 39, 4,'https://wow.gamepedia.com/Jaina_Proudmoore#/media/File:Jaina_Proudmoore_of_Kul_Tiras.jpg');\n" +
                "\n" +
                "insert into player ( normal_position, number, person_id, team_id,player_image) values ('Attack', '10', 40, 4,'https://wow.gamepedia.com/Sylvanas_Windrunner#/media/File:Sylvanas_by_Erik_Braddock_-_cropped.jpg');\n" +
                "\n" +
                "insert into player ( normal_position, number, person_id, team_id,player_image) values ('Attack', '15', 41, 4,'https://cdnb.artstation.com/p/assets/images/images/012/415/077/large/laurits-rask-saurfang-10mb.jpg?1534695352');\n" +
                "\n" +
                "insert into player ( normal_position, number, person_id, team_id,player_image) values ('Keeper', '1', 42, 4,'https://wow.gamepedia.com/Anduin_Wrynn#/media/File:Anduin_by_Erik_Braddock_-_cropped.jpg');\n" +
                "\n" +
                "insert into player ( normal_position, number, person_id, team_id,player_image) values ('Defence', '17', 43, 4,'https://d1u5p3l4wpay3k.cloudfront.net/wowpedia/b/be/Varian_Wei.jpg?version=f1dae75b94bf31cafa21029ba6300d7c');\n" +
                "\n" +
                "insert into player ( normal_position, number, person_id, team_id,player_image) values ('Defence', '12', 44, 4,'https://wow.gamepedia.com/Malfurion_Stormrage#/media/File:Malfurion_WotE_Cropped.jpg');\n" +
                "\n" +
                "insert into player ( normal_position, number, person_id, team_id,player_image) values ('Defence', '35', 45, 4,'https://d1u5p3l4wpay3k.cloudfront.net/wowpedia/4/47/Tyrande_HS_cropped.jpg?version=7c5db9a60120f665d0d72ca41b035122');\n" +
                "\n" +
                "insert into player ( normal_position, number, person_id, team_id,player_image) values ('Center', '4', 46, 4,'https://wow.gamepedia.com/Baine_Bloodhoof#/media/File:Glowei_Baine_Bloodhoof.jpg');\n" +
                "\n" +
                "insert into player ( normal_position, number, person_id, team_id,player_image) values ('Center', '11', 47, 4,'https://d1u5p3l4wpay3k.cloudfront.net/wowpedia/c/c9/Genn_Greymane_Battle_for_Azeroth_Cinematic.jpg?version=083c4eabf76ded7ea542b2deb12364c1');\n" +
                "\n" +
                "insert into player ( normal_position, number, person_id, team_id,player_image) values ('Center', '21', 48, 4,'https://wow.gamepedia.com/Thrall#/media/File:Thrall_WarCraft_Raneman.jpg');\n";

        System.out.println("started to create a table");

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
