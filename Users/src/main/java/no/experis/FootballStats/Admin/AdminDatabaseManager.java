package no.experis.FootballStats.Admin;

import java.sql.*;
import java.util.ArrayList;

public class AdminDatabaseManager {

    private Connection conn = null;

    private String id;
    private String firstname;
    private String lastname;
    private String date;
    private String addressid;


    // MAIN DB CONNECTION
    public Connection connectToMainDB() {
        final String DB_HOST = "case1234.cqjagjopuiru.eu-central-1.rds.amazonaws.com";
        final String DB_PORT = "5432";
        final String DB_USER = "case1234";
        final String DB_PASSWD = "case1234";
        final String DB_NAME = "caseDB";
        final String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
        } catch (ClassNotFoundException | SQLException ex) {
            //log.error(ex);
            System.out.println(ex.getMessage());
        }
        return conn;
    }

    // USER DB CONNECTION
    public Connection connectToUserDB() {
        final String DB_HOST = "users.cqjagjopuiru.eu-central-1.rds.amazonaws.com";
        final String DB_PORT = "5432";
        final String DB_USER = "users";
        final String DB_PASSWD = "users123";
        final String DB_NAME = "usersDB";
        final String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
        } catch (ClassNotFoundException | SQLException ex) {
            //log.error(ex);
            System.out.println(ex.getMessage());
        }
        return conn;
    }

    // TODO: Insert statements ...

    // USER STATEMENTS
    public void createUser(String email,String password) {
        String sql = "INSERT INTO users(email,password) VALUES(?,?)";


        try (Connection conn = this.connectToUserDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createUserWatchPlayer(int player_watch_id,int user_id) {
        String sql = "INSERT INTO player_watchlist(player_watch_id,user_id) VALUES(?,?)";

        try (Connection conn = this.connectToUserDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, player_watch_id);
            pstmt.setInt(2, user_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createUserWatchTeam(int team_watch_id,int user_id) {
        String sql = "INSERT INTO team_watchlist(team_watch_id,user_id) VALUES(?,?)";


        try (Connection conn = this.connectToUserDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, team_watch_id);
            pstmt.setInt(2, user_id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




    // ADMIN STATEMENTS

    // TODO: Insert statements ...
    public void createAddress(String address_line_1,String address_line_2,String address_line_3,String postal_code,String city,String country) {
        String sql = "INSERT INTO address(address_line_1,address_line_2,address_line_3,postal_code,city,country) VALUES(?,?,?,?,?,?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, address_line_1);
            pstmt.setString(2, address_line_2);
            pstmt.setString(3, address_line_3);
            pstmt.setString(4, postal_code);
            pstmt.setString(5, city);
            pstmt.setString(6, country);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createSeason(String start_date,String end_date,String name,String description) {
        String sql = "INSERT INTO season(start_date,end_date,name,description) VALUES (?,?,?,?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, start_date);
            pstmt.setString(2, end_date);
            pstmt.setString(3, name);
            pstmt.setString(4, description);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createLocation(String name,String description,int address_id) {
        String sql = "INSERT INTO location(name,description,address_id) VALUES (?,?,?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setInt(3, address_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createAssociation(String name,String description) {
        String sql = "INSERT INTO association(name,description) VALUES (?,?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createPerson(String first_name,String last_name,String date_of_birth,int address_id) {
        String sql = "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES (?,?,?,?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, date_of_birth);
            pstmt.setInt(4, address_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createGoalType(String type) {
        String sql = "INSERT INTO goal_type(type) VALUES (?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createContact(String contact_type,String contact_detail, int person_id) {
        String sql = "INSERT INTO contact(contact_type,contact_detail, person_id) VALUES (?,?,?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contact_type);
            pstmt.setString(2, contact_detail);
            pstmt.setInt(3, person_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createOwner(int person_id) {
        String sql = "INSERT INTO owner(person_id) VALUES (?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createCoach(int person_id) {
        String sql = "INSERT INTO coach(person_id) VALUES (?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTeam(int owner_id,int association_id, int coach_id, int location_id) {
        String sql = "INSERT INTO team(owner_id,association_id,coach_id,location_id) VALUES (?,?,?,?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, owner_id);
            pstmt.setInt(2, association_id);
            pstmt.setInt(3, coach_id);
            pstmt.setInt(4, location_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createMatch(String match_date, int season_id,int location_id, int home_team_id, int away_team_id) {
        String sql = "INSERT INTO match(match_date,season_id,location_id,home_team_id,away_team_id) VALUES (?,?,?,?,?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, match_date);
            pstmt.setInt(2, season_id);
            pstmt.setInt(3, location_id);
            pstmt.setInt(4, home_team_id);
            pstmt.setInt(5, away_team_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createResult(int score,String result, int match_id, int team_id) {
        String sql = "INSERT INTO result(score,result,match_id,team_id) VALUES (?,?,?,?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, score);
            pstmt.setString(2, result);
            pstmt.setInt(3, match_id);
            pstmt.setInt(4, team_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createPlayer(String normal_position,String number, int person_id, int team_id) {
        String sql = "INSERT INTO Player(normal_position,number,person_id,team_id) VALUES (?,?,?,?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, normal_position);
            pstmt.setString(2, number);
            pstmt.setInt(3, person_id);
            pstmt.setInt(4, team_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createMatchPosition(String position,int player_id, int match_id) {
        String sql = "INSERT INTO MATCH_POSITION(position,player_id,match_id) VALUES (?,?,?)";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, position);
            pstmt.setInt(2, player_id);
            pstmt.setInt(3, match_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createMatchGoal(String description,int goal_type_id, int match_id, int player_id) {
        String sql = "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES (?,?,?,?);";


        try (Connection conn = this.connectToMainDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, description);
            pstmt.setInt(2, goal_type_id);
            pstmt.setInt(3, match_id);
            pstmt.setInt(4, player_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


/*
    public void insertPerson() {

        String sql = "INSERT ";


        try (Connection conn = this.connectToMainDB();  // Main db
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                id = Integer.toString(rs.getInt("PERSON_ID"));
                firstname = rs.getString("FIRST_NAME");
                lastname = rs.getString("LAST_NAME");
                date = rs.getString("DATE_OF_BIRTH");
                addressid = Integer.toString(rs.getInt("ADDRESS_ID"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

*/

}