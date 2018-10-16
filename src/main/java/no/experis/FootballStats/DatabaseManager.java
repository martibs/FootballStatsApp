package no.experis.FootballStats;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    private static final String connectionURL = "jdbc:postgresql://mydbinstance.cqjagjopuiru.eu-central-1.rds.amazonaws.com:1433/masterdb";

    private Connection connect() {
        Connection conn = null;
        String user = "masterUser";
        String password = "master";

        try {
            conn = DriverManager.getConnection(connectionURL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public String findPerson() {
        String sql = "SELECT * FROM Person";
        String person = "";

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
