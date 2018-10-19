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


}
