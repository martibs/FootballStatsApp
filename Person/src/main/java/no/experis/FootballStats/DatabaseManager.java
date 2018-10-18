package no.experis.FootballStats;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    //private static final String connectionURL = "jdbc:postgresql://mydbinstance.cqjagjopuiru.eu-central-1.rds.amazonaws.com:1433/masterdb";
    //private static final String connectionURL = "jdbc:postgresql://courseinstance.cqjagjopuiru.eu-central-1.rds.amazonaws.com:5432/courseDB";
    private static final String connectionURL = "jdbc:postgresql://127.0.0.1:5432/Case_db";

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

    public ArrayList<Player> getAllPeople() {

        Player tempPlayer = null;
        ArrayList<Player> tempPlayersList = new ArrayList<Player>();

        String sql = "Select * from player inner join person on person.person_id = player.person_id";

        String id = null;
        String firstname = null;
        String lastname = null;
        String date = null;
        String addressid = null;
        String player_id;
        String normal_position;
        String number;
        String team_id;

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {

                id = Integer.toString(rs.getInt("person_id"));
                firstname = rs.getString("first_name");
                lastname = rs.getString("last_name");
                date = rs.getString("date_of_birth");
                addressid = Integer.toString(rs.getInt("address_id"));
                player_id = Integer.toString(rs.getInt("player_id"));
                normal_position = rs.getString("normal_position");
                number = rs.getString("number");
                team_id = Integer.toString(rs.getInt("team_id"));

                tempPlayer = new Player(id,firstname,lastname,date,addressid, player_id, normal_position, number, team_id);
                tempPlayersList.add(tempPlayer);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempPlayersList;
    }


}
