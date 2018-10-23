package no.experis.FootballStats.UserSetup;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    private Connection conn = null;

    private String id;
    private String firstname;
    private String lastname;
    private String date;
    private String addressid;

    public Connection connect() {
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

        String sql = "INSERT ";

        User tempUser = null;
        ArrayList<User> tempUserList = new ArrayList<User>();
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

                //tempUser = new UserSetup(id,firstname,lastname,date,addressid, player_id, normal_position, number, team_id);
                tempUserList.add(tempUser);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // TODO: Get user data from the database.
    public ArrayList<User> getUsersFromDb() {

        String sql = "SELECT * FROM USER ";

        User tempUser = null;
        ArrayList<User> tempUserList = new ArrayList<User>();
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

                // TODO: Create user
                //tempUser = new UserSetup();
                tempUserList.add(tempUser);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempUserList;
    }

}
