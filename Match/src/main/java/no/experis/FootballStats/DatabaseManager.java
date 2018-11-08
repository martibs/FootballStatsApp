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

    private String match_id;
    private String match_date;
    private String home_team_id;
    private String away_team_id;
    private String season_id;
    private String location_id;


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


    public ArrayList<Match> getMatches() {
        String sql = "SELECT * FROM MATCH";

        Match tempMatch = null;
        ArrayList<Match> tempMatchList = new ArrayList<Match>();


        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                match_id = Integer.toString(rs.getInt("MATCH_ID"));
                match_date = rs.getString("MATCH_DATE");
                home_team_id = Integer.toString(rs.getInt("HOME_TEAM_ID"));
                away_team_id = Integer.toString(rs.getInt("AWAY_TEAM_ID"));
                season_id = Integer.toString(rs.getInt("SEASON_ID"));
                location_id = Integer.toString(rs.getInt("LOCATION_ID"));

                tempMatch = new Match(match_id, match_date, home_team_id, away_team_id, season_id, location_id);
                tempMatchList.add(tempMatch);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempMatchList;
    }

    public ArrayList<Match> getUpcommingMatches() {
        String sql = "select *\n" +
                "from match\n" +
                "where(match_id) not in(\n" +
                "Select match_id\n" +
                "From result\n" +
                ")\n" +
                "Order by match_date;";

        Match tempMatch = null;
        ArrayList<Match> tempMatchList = new ArrayList<Match>();


        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                match_id = Integer.toString(rs.getInt("MATCH_ID"));
                match_date = rs.getString("MATCH_DATE");
                home_team_id = Integer.toString(rs.getInt("HOME_TEAM_ID"));
                away_team_id = Integer.toString(rs.getInt("AWAY_TEAM_ID"));
                season_id = Integer.toString(rs.getInt("SEASON_ID"));
                location_id = Integer.toString(rs.getInt("LOCATION_ID"));

                tempMatch = new Match(match_id, match_date, home_team_id, away_team_id, season_id, location_id);
                tempMatchList.add(tempMatch);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempMatchList;
    }

    public ArrayList<Match> getCompletedMatches() {
        String sql = "select *\n" +
                "from match\n" +
                "where(match_id) in(\n" +
                "Select match_id\n" +
                "From result\n" +
                ")\n" +
                "Order by match_date;";

        Match tempMatch = null;
        ArrayList<Match> tempMatchList = new ArrayList<Match>();


        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                match_id = Integer.toString(rs.getInt("MATCH_ID"));
                match_date = rs.getString("MATCH_DATE");
                home_team_id = Integer.toString(rs.getInt("HOME_TEAM_ID"));
                away_team_id = Integer.toString(rs.getInt("AWAY_TEAM_ID"));
                season_id = Integer.toString(rs.getInt("SEASON_ID"));
                location_id = Integer.toString(rs.getInt("LOCATION_ID"));

                tempMatch = new Match(match_id, match_date, home_team_id, away_team_id, season_id, location_id);
                tempMatchList.add(tempMatch);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempMatchList;
    }

}
