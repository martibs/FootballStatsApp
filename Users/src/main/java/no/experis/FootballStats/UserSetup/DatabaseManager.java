package no.experis.FootballStats.UserSetup;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    private Connection conn = null;

    private String userId;
    private String email;
    private String password;
    private ArrayList<String> player_watchlist;
    private ArrayList<String> team_watchlist;

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

    // TODO: Get user data from the database.
    public ArrayList<User> getUsersFromDb() {

        String sql = "SELECT * FROM USERS ";

        User tempUser = null;
        ArrayList<User> tempUserList = new ArrayList<User>();

        try (Connection conn = this.connectToUserDB();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {

                email = rs.getString("EMAIL");
                password = rs.getString("PASSWORD");

                // TODO: Create user
                //tempUser = new UserSetup();
                tempUserList.add(tempUser);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempUserList;
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

}
