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

    private String goal_id;
    private String player_id;
    private String goal_type_id;
    private String match_id;
    private String description;
    private String type;


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

    public ArrayList<Goal> getGoals() {
        String sql = "SELECT * FROM MATCH_GOAL INNER JOIN GOAL_TYPE ON MATCH_GOAL.GOAL_TYPE_ID = GOAL_TYPE.GOAL_TYPE_ID";

        Goal tempGoal = null;
        ArrayList<Goal> tempGoalList = new ArrayList<Goal>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {


            // loop through the result set
            while (rs.next()) {
                goal_id = Integer.toString(rs.getInt("GOAL_ID"));
                player_id = Integer.toString(rs.getInt("PLAYER_ID"));
                goal_type_id = Integer.toString(rs.getInt("GOAL_TYPE_ID"));
                match_id = Integer.toString(rs.getInt("MATCH_ID"));
                description = rs.getString("DESCRIPTION");
                type = rs.getString("TYPE");


                tempGoal = new Goal(goal_id,player_id,goal_type_id,match_id,description, type);
                tempGoalList.add(tempGoal);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempGoalList;
    }

}
