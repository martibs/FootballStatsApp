package no.experis.FootballStats;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    private final String DB_HOST = "ec2-46-51-184-229.eu-west-1.compute.amazonaws.com";
    private final String DB_PORT = "5432";
    private final String DB_USER = "uvmyugpkrtubxx";
    private final String DB_PASSWD = "a42ebfe205e754d8b170f120ab30d5679bf64a324b80b2bc429c3e2e90f9f353";
    private final String DB_NAME = "d5togjfivbt4tr";
    private final String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    private Connection conn = null;

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
        String team_id;
        String association_id;
        String coach_id;
        String owner_id;
        String location_id;

        String sql = "SELECT * FROM TEAM";

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

                tempTeam = new Team(team_id,association_id,coach_id,owner_id,location_id);
                tempPlayersList.add(tempTeam);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempPlayersList;
    }

    public ArrayList<Association> getAssociations() {
        String association_id;
        String association_name;
        String association_description;

        String sql = "SELECT * FROM ASSOCIATION";

        Association tempAssociation = null;
        ArrayList<Association> tempAssociationList = new ArrayList<Association>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                association_id = Integer.toString(rs.getInt("association_id"));
                association_name = rs.getString("name");
                association_description = rs.getString("description");

                tempAssociation = new Association(association_id, association_name, association_description);
                tempAssociationList.add(tempAssociation);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempAssociationList;
    }

    public ArrayList<FootballTeam> getAllTeamData() {
        String team_id;
        String association_id;
        String coach_id;
        String owner_id;
        String location_id;
        String association_name;
        String association_description;

        String sql = "SELECT * FROM TEAM INNER JOIN ASSOCIATION ON ASSOCIATION.ASSOCIATION_ID = TEAM.ASSOCIATION_ID";

        FootballTeam tempTeam = null;
        ArrayList<FootballTeam> tempPlayersList = new ArrayList<FootballTeam>();

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


                tempTeam = new FootballTeam(team_id,association_id,coach_id,owner_id,location_id, association_name, association_description);
                tempPlayersList.add(tempTeam);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempPlayersList;
    }

}
