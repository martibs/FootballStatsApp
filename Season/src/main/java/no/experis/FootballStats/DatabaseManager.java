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

    private Date start_date;
    private Date end_date;
    private String name;
    private String description;
    private String season_id;


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

    public ArrayList<Season> getSeasons() {
        String sql = "SELECT * FROM SEASON";

        Season tempSeason = null;
        ArrayList<Season> tempSeasonList = new ArrayList<Season>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                season_id = Integer.toString(rs.getInt("SEASON_ID"));
                start_date = rs.getDate("START_DATE");
                end_date = rs.getDate("END_DATE");
                name = rs.getString("NAME");
                description = rs.getString("DESCRIPTION");

                tempSeason = new Season(season_id, start_date, end_date, name, description);
                tempSeasonList.add(tempSeason);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempSeasonList;
    }

}
