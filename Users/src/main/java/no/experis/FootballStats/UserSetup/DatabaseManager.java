package no.experis.FootballStats.UserSetup;

import no.experis.FootballStats.Admin.Models.Contact;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {
    private Connection conn = null;

    private final String DB_HOST = "ec2-46-51-184-229.eu-west-1.compute.amazonaws.com";
    private final String DB_PORT = "5432";
    private final String DB_USER = "uvmyugpkrtubxx";
    private final String DB_PASSWD = "a42ebfe205e754d8b170f120ab30d5679bf64a324b80b2bc429c3e2e90f9f353";
    private final String DB_NAME = "d5togjfivbt4tr";
    private final String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    private String user_id;
    private String email;
    private String password;
    private ArrayList<String> player_watchlist;
    private ArrayList<String> team_watchlist;

    // USER DB CONNECTION
    public Connection connectToUserDB() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
        } catch (ClassNotFoundException | SQLException ex) {
            //log.error(ex);
            System.out.println(ex.getMessage());
        }
        return conn;
    }


    // TODO: Store user data when the user registers their account.
    public void insertUserInDB() {

        String sql = "INSERT INTO USERS(email,password) VALUES(?,?)";

        try (Connection conn = this.connectToUserDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<User> getUsersFromDb() {
        String sql = "SELECT * FROM Users";

        String contact_id;
        String person_id;
        String contact_type;
        String contact_detail;

        User tempContact = null;
        ArrayList<User> tempUsers = new ArrayList<User>();

        try (Connection conn = this.connectToUserDB();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                user_id = rs.getString("user_id");
                email = rs.getString("EMAIL");


                tempContact = new User(user_id, email);
                tempUsers.add(tempContact);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempUsers;
    }

    public void deleteUserWatchPlayer(int player_watch_id,int user_id) {
        String sql = "DELETE FROM player_watchlist WHERE player_watch_id = user_id";

        try (Connection conn = this.connectToUserDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteUserWatchTeam(int team_watch_id,int user_id) {
        String sql = "DELETE FROM team_watchlist WHERE team_watch_id = user_id";


        try (Connection conn = this.connectToUserDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
