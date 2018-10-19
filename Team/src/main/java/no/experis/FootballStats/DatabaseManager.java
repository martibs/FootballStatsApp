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

    private String team_id;
    private String association_id;
    private String coach_id;
    private String owner_id;
    private String location_id;
    private String association_name;
    private String association_description;


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

    public ArrayList<Team> getTeams() {
        String sql = "SELECT * FROM TEAM INNER JOIN ASSOCIATION ON ASSOCIATION.ASSOCIATION_ID = TEAM.ASSOCIATION_ID";

        Team tempTeam = null;
        ArrayList<Team> tempPlayersList = new ArrayList<Team>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                team_id = Integer.toString(rs.getInt("TEAM_ID"));
                association_id = Integer.toString(rs.getInt("ASSOCIATION_ID"));
                coach_id = Integer.toString(rs.getInt("COACH_ID"));
                owner_id = Integer.toString(rs.getInt("OWNER_ID"));
                location_id = Integer.toString(rs.getInt("LOCATION_ID"));
                association_name = rs.getString("NAME");
                association_description = rs.getString("DESCRIPTION");


                tempTeam = new Team(team_id,association_id,coach_id,owner_id,location_id, association_name, association_description);
                tempPlayersList.add(tempTeam);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempPlayersList;
    }

}
