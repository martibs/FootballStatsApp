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
    public void createUser() {

        String sql = "INSERT INTO address(address_id,address_line_1,address_line_2,address_line_3,postal_code,city,country) VALUES(?,?,?,?,?,?,?)";


        try (Connection conn = this.connectToUserDB();  // User db
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


    // ADMIN STATEMENTS

    // TODO: Insert statements ...
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
}
