package no.experis.FootballStats;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    //private static final String connectionURL = "jdbc:postgresql://mydbinstance.cqjagjopuiru.eu-central-1.rds.amazonaws.com:1433/masterdb";
    //private static final String connectionURL = "jdbc:postgresql://courseinstance.cqjagjopuiru.eu-central-1.rds.amazonaws.com:5432/courseDB";
    private static final String connectionURL = "jdbc:postgresql://127.0.0.1:5432/Case_db";

    private Person person;

    private Connection connect() {
        Connection conn = null;
        String user = "postgres";
        String password = "test123";

        try {
            conn = DriverManager.getConnection(connectionURL,user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public ArrayList<Person> getAllPeople() {

        ArrayList<Person> tempPerson = new ArrayList<Person>();
        String sql = "Select * from person";
        int id = -2;
        String firstname = null;
        String lastname = null;
        String date = null;
        int addressid = -1;

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {

                id = rs.getInt("person_id");
                firstname = rs.getString("first_name");
                lastname= rs.getString("last_name");
                date= rs.getString("date_of_birth");
                addressid= rs.getInt("address_id");


                //System.out.println(rs.getInt("personID"));
                person = new Person(id,firstname,lastname,date,addressid);
                tempPerson.add(person);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempPerson;
    }

    public String findPerson() {
        String sql = "SELECT * FROM person;";
        String person = "dette er en test!";

        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            person = resultSet.getString("lastname");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return person;
    }
}
