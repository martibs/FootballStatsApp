package no.experis.FootballStats.Admin;

import no.experis.FootballStats.Admin.Models.Address;
import no.experis.FootballStats.Admin.Models.Contact;

import java.sql.*;
import java.util.ArrayList;

public class AdminDatabaseManager {
    private Connection conn = null;

    private final String DB_HOST = "ec2-46-51-184-229.eu-west-1.compute.amazonaws.com";
    private final String DB_PORT = "5432";
    private final String DB_USER = "uvmyugpkrtubxx";
    private final String DB_PASSWD = "a42ebfe205e754d8b170f120ab30d5679bf64a324b80b2bc429c3e2e90f9f353";
    private final String DB_NAME = "d5togjfivbt4tr";
    private final String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    // DB CONNECTION
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

    // ***** USER *****

    public void createUser(String email,String password) {
        String sql = "INSERT INTO users(email,password) VALUES(?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createUserWatchPlayer(int player_watch_id,int user_id) {
        String sql = "INSERT INTO player_watchlist(player_watch_id,user_id) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, player_watch_id);
            pstmt.setInt(2, user_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createUserWatchTeam(int team_watch_id,int user_id) {
        String sql = "INSERT INTO team_watchlist(team_watch_id,user_id) VALUES(?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, team_watch_id);
            pstmt.setInt(2, user_id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // ***** SEASON *****

    public void createSeason(Date start_date,Date end_date,String name,String description) {
        String sql = "INSERT INTO season(start_date,end_date,name,description) VALUES (?,?,?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, start_date);
            pstmt.setDate(2, end_date);
            pstmt.setString(3, name);
            pstmt.setString(4, description);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateSeason(Date start_date,Date end_date,String name,String description, int season_id) {
        String sql = "UPDATE SEASON set start_date = ? ,end_date = ?, name = ?, description = ? WHERE season_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, start_date);
            pstmt.setDate(2, end_date);
            pstmt.setString(3, name);
            pstmt.setString(4, description);
            pstmt.setInt(5,season_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // **** TEAM *****

    public void createAssociation(String name,String description) {
        String sql = "INSERT INTO association(name,description) VALUES (?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAssociation(String name,String description, int association_id) {
        String sql = "UPDATE MATCH_GOAL set name = ? ,description = ? WHERE association_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setInt(3, association_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTeam(int owner_id,int association_id, int coach_id, int location_id) {
        String sql = "INSERT INTO team(owner_id,association_id,coach_id,location_id) VALUES (?,?,?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, owner_id);
            pstmt.setInt(2, association_id);
            pstmt.setInt(3, coach_id);
            pstmt.setInt(4, location_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int updateTeam(int owner_id,int association_id, int coach_id, int location_id,int team_id) {
        String sql = "UPDATE TEAM set owner_id = ? ,association_id = ?, coach_id = ?, location_id = ? WHERE team_id = ? RETURNING association_id";

        int lastTeam = -1;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, owner_id);
            pstmt.setInt(2, association_id);
            pstmt.setInt(3, coach_id);
            pstmt.setInt(4, location_id);
            pstmt.setInt(5, location_id);
            pstmt.setInt(6, team_id);
            pstmt.execute();

            ResultSet rs = pstmt.getResultSet();

            while(rs.next()) {
                lastTeam = rs.getInt(1);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lastTeam;

    }


    // **** GOAL *****
    public void createGoalType(String type) {
        String sql = "INSERT INTO goal_type(type) VALUES (?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateGoalType(String type, int goal_type_id) {
        String sql = "UPDATE Player set type = ? WHERE goal_type_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            pstmt.setInt(2, goal_type_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void createMatchGoal(String description,int goal_type_id, int match_id, int player_id) {
        String sql = "INSERT INTO MATCH_GOAL(description,goal_type_id,match_id,player_id) VALUES (?,?,?,?);";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, description);
            pstmt.setInt(2, goal_type_id);
            pstmt.setInt(3, match_id);
            pstmt.setInt(4, player_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateMatchGoal(String description,int goal_type_id, int match_id, int player_id, int goal_id) {
        String sql = "UPDATE MATCH_GOAL set description = ? ,goal_type_id = ?, match_id = ?, player_id = ? WHERE goal_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, description);
            pstmt.setInt(2, goal_type_id);
            pstmt.setInt(3, match_id);
            pstmt.setInt(4, player_id);
            pstmt.setInt(5,goal_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // ****** MATCH *****

    public void createMatch(Date match_date, int season_id,int location_id, int home_team_id, int away_team_id) {
        String sql = "INSERT INTO match(match_date,season_id,location_id,home_team_id,away_team_id) VALUES (?,?,?,?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, match_date);
            pstmt.setInt(2, season_id);
            pstmt.setInt(3, location_id);
            pstmt.setInt(4, home_team_id);
            pstmt.setInt(5, away_team_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateMatch(Date match_date, int season_id,int location_id, int home_team_id, int away_team_id, int match_id) {
        String sql = "UPDATE MATCH set match_date = ? ,season_id = ?, location_id = ?, home_team_id = ?, away_team_id = ?  WHERE match_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, match_date);
            pstmt.setInt(2, season_id);
            pstmt.setInt(3, location_id);
            pstmt.setInt(4, home_team_id);
            pstmt.setInt(5,away_team_id);
            pstmt.setInt(6,match_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createMatchPosition(String position,int player_id, int match_id) {
        String sql = "INSERT INTO MATCH_POSITION(position,player_id,match_id) VALUES (?,?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, position);
            pstmt.setInt(2, player_id);
            pstmt.setInt(3, match_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateMatchPosition(String position,int new_player_id, int new_match_id,int player_id, int match_id) {
        String sql = "UPDATE MATCH_POSITION set position = ? ,player_id = ?, match_id = ? WHERE match_id = ? and player_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, position);
            pstmt.setInt(2, new_player_id);
            pstmt.setInt(3, new_match_id);
            pstmt.setInt(4, match_id);
            pstmt.setInt(5,player_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // ***** RESULT *****

    public void createResult(int score,String result, int match_id, int team_id) {
        String sql = "INSERT INTO result(score,result,match_id,team_id) VALUES (?,?,?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, score);
            pstmt.setString(2, result);
            pstmt.setInt(3, match_id);
            pstmt.setInt(4, team_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateResult(int score,String result, int new_match_id, int new_team_id, int match_id, int team_id) {
        String sql = "UPDATE RESULT set score = ? ,result = ?, match_id = ?, team_id = ? WHERE match_id = ? and team_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, score);
            pstmt.setString(2, result);
            pstmt.setInt(3, new_match_id);
            pstmt.setInt(4, new_team_id);
            pstmt.setInt(5,match_id);
            pstmt.setInt(5,team_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // ***** PERSON *****
    public int createPerson(String first_name,String last_name, Date date_of_birth,int address_id) {
        String sql = "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES (?,?,?,?) RETURNING person_id";

        int lastPerson = -1;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setDate(3, date_of_birth);
            pstmt.setInt(4, address_id);
            pstmt.execute();

            ResultSet rs = pstmt.getResultSet();

            while(rs.next()) {
                lastPerson = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lastPerson;
    }

    public int updatePerson(String first_name,String last_name, Date date_of_birth,int real_id) {
        String sql = "UPDATE Person set first_name = ? ,last_name = ?, date_of_birth = ? WHERE person_id = ? RETURNING person_id";

        int lastPerson = -1;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setDate(3, date_of_birth);
            pstmt.setInt(4, real_id);
            pstmt.execute();

            ResultSet rs = pstmt.getResultSet();

            while(rs.next()) {
                lastPerson = rs.getInt(1);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lastPerson;

    }

    public void updatePlayer(String normal_position, String number, int team_id, int real_id) {
        String sql = "UPDATE Player set normal_position = ? ,number = ?, team_id = ? WHERE person_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, normal_position);
            pstmt.setString(2, number);
            pstmt.setInt(3, team_id);
            pstmt.setInt(4, real_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createPlayer(String normal_position,String number, int person_id, int team_id) {
        String sql = "INSERT INTO Player(normal_position,number,person_id,team_id) VALUES (?,?,?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, normal_position);
            pstmt.setString(2, number);
            pstmt.setInt(3, person_id);
            pstmt.setInt(4, team_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public void createOwner(int person_id) {
        String sql = "INSERT INTO owner(person_id) VALUES (?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateOwner(int person_id, int owner_id) {
        String sql = "UPDATE owner set person_id = ? WHERE owner_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_id);
            pstmt.setInt(2, owner_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createCoach(int person_id) {
        String sql = "INSERT INTO coach(person_id) VALUES (?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCoach(int person_id, int coach_id) {
        String sql = "UPDATE owner set person_id = ? WHERE coach_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_id);
            pstmt.setInt(2, coach_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // ***** ADDRESS *****

    public int createAddress(String address_line_1,String address_line_2,String address_line_3,String postal_code,String city,String country) {
        String sql = "INSERT INTO address(address_line_1,address_line_2,address_line_3,postal_code,city,country) VALUES(?,?,?,?,?,?) RETURNING address_id";

        int addressIdFromRS = -1;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, address_line_1);
            pstmt.setString(2, address_line_2);
            pstmt.setString(3, address_line_3);
            pstmt.setString(4, postal_code);
            pstmt.setString(5, city);
            pstmt.setString(6, country);
            pstmt.execute();

            ResultSet rs = pstmt.getResultSet();

            while(rs.next()) {
                addressIdFromRS = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return addressIdFromRS;
    }

    public void createLocation(String name,String description,int address_id) {
        String sql = "INSERT INTO location(name,description,address_id) VALUES (?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setInt(3, address_id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Address updateAddress(String address_line_1, String address_line_2, String address_line_3, String postal_code, String city, String country, int real_id) {
        String sql = "UPDATE address set address_line_1 = ? ,address_line_2 = ? , address_line_3 = ? , postal_code = ?, city = ? , country = ? WHERE address_id = ?";

        Address tempAddress = new Address(address_line_1,address_line_2,address_line_3,postal_code,city,country);

        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, address_line_1);
            pstmt.setString(2, address_line_2);
            pstmt.setString(3, address_line_3);
            pstmt.setString(4, postal_code);
            pstmt.setString(5, city);
            pstmt.setString(6, country);
            pstmt.setInt(7, real_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempAddress;
    }

    public Address updateLocation(String location_name, String description, int real_id) {
        String sql = "UPDATE location set name = ? , description = ? WHERE location_id = ?";

        Address tempLocation = new Address(location_name, description);

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, location_name);
            pstmt.setString(2, description);
            pstmt.setInt(3, real_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempLocation;
    }

    public void deleteAddress(String address_id) {
        String sql = "DELETE FROM address WHERE address_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(address_id));
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createContact(String contact_type,String contact_detail, int person_id) {
        String sql = "INSERT INTO contact(contact_type,contact_detail, person_id) VALUES (?,?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contact_type);
            pstmt.setString(2, contact_detail);
            pstmt.setInt(3, person_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void updateContact(String contact_type, String contact_detail, int person_id) {
        String sql = "UPDATE Contact set contact_type = ? , contact_detail = ? WHERE person_id = ?";

        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contact_type);
            pstmt.setString(2, contact_detail);
            pstmt.setInt(3, person_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Contact> getContacts() {
        String sql = "SELECT * FROM Contact";

        int contact_id;
        int person_id;
        String contact_type;
        String contact_detail;


        Contact tempContact = null;
        ArrayList<Contact> tempContactList = new ArrayList<Contact>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {


            // loop through the result set
            while (rs.next()) {
                contact_id = rs.getInt("CONTACT_ID");
                person_id = rs.getInt("PERSON_ID");
                contact_type = rs.getString("CONTACT_TYPE");
                contact_detail = rs.getString("CONTACT_DETAIL");


                tempContact = new Contact(contact_id, person_id, contact_type, contact_detail);
                tempContactList.add(tempContact);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempContactList;
    }

}
