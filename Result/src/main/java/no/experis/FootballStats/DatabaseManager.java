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
    private String team_id;
    private String score;
    private String result;

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

    public ArrayList<Result> getResults() {
        String sql = "SELECT * FROM RESULT";

        Result tempResult = null;
        ArrayList<Result> tempResultList = new ArrayList<Result>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                match_id = Integer.toString(rs.getInt("MATCH_ID"));
                team_id = Integer.toString(rs.getInt("TEAM_ID"));
                score = rs.getString("SCORE");
                result = rs.getString("RESULT");

                tempResult = new Result(match_id, team_id, score, result);
                tempResultList.add(tempResult);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempResultList;
    }


}
