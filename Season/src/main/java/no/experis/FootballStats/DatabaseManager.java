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

    private String start_date;
    private String end_date;
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
                start_date = rs.getString("START_DATE");
                end_date = rs.getString("END_DATE");
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
