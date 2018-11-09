package no.experis.FootballStats;

import no.experis.FootballStats.Models.Goal;
import no.experis.FootballStats.Models.GoalType;

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
        String sql = "SELECT * FROM MATCH_GOAL";

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

                tempGoal = new Goal(goal_id,player_id,goal_type_id,match_id,description);
                tempGoalList.add(tempGoal);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempGoalList;
    }

    public ArrayList<Goal> getGoalsInOneMatch(int match_id1) {
        String sql = "SELECT * FROM MATCH_GOAL WHERE MATCH_ID = ?";

        Goal tempGoal = null;
        ArrayList<Goal> tempGoalList = new ArrayList<Goal>();

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,match_id1);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();

            // loop through the result set
            while (rs.next()) {
                goal_id = Integer.toString(rs.getInt("GOAL_ID"));
                player_id = Integer.toString(rs.getInt("PLAYER_ID"));
                goal_type_id = Integer.toString(rs.getInt("GOAL_TYPE_ID"));
                match_id = Integer.toString(rs.getInt("MATCH_ID"));
                description = rs.getString("DESCRIPTION");

                tempGoal = new Goal(goal_id,player_id,goal_type_id,match_id,description);
                tempGoalList.add(tempGoal);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempGoalList;
    }

    public ArrayList<Goal> getGoalsForPlayer(int player_id1) {
        String sql = "SELECT * FROM MATCH_GOAL WHERE Player_id = ?";

        Goal tempGoal = null;
        ArrayList<Goal> tempGoalList = new ArrayList<Goal>();

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,player_id1);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();

            // loop through the result set
            while (rs.next()) {
                goal_id = Integer.toString(rs.getInt("GOAL_ID"));
                player_id = Integer.toString(rs.getInt("PLAYER_ID"));
                goal_type_id = Integer.toString(rs.getInt("GOAL_TYPE_ID"));
                match_id = Integer.toString(rs.getInt("MATCH_ID"));
                description = rs.getString("DESCRIPTION");

                tempGoal = new Goal(goal_id,player_id,goal_type_id,match_id,description);
                tempGoalList.add(tempGoal);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempGoalList;
    }


    public ArrayList<GoalType> getGoalType() {
        String sql = "SELECT * FROM GOAL_TYPE";

        GoalType tempGoalType = null;
        ArrayList<GoalType> tempGoalTypeList = new ArrayList<GoalType>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                goal_type_id = Integer.toString(rs.getInt("GOAL_TYPE_ID"));
                type = rs.getString("TYPE");

                tempGoalType = new GoalType(goal_type_id, type);
                tempGoalTypeList.add(tempGoalType);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempGoalTypeList;
    }

}
