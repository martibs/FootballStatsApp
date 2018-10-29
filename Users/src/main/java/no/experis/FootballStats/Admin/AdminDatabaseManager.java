package no.experis.FootballStats.Admin;

import no.experis.FootballStats.Admin.Models.Address;

import java.sql.*;

public class AdminDatabaseManager {
    private Connection conn = null;

    private final String DB_HOST = "ec2-46-51-184-229.eu-west-1.compute.amazonaws.com";
    private final String DB_PORT = "5432";
    private final String DB_USER = "uvmyugpkrtubxx";
    private final String DB_PASSWD = "a42ebfe205e754d8b170f120ab30d5679bf64a324b80b2bc429c3e2e90f9f353";
    private final String DB_NAME = "d5togjfivbt4tr";
    private final String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    private String addressId;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String postalCode;
    private String city;
    private String country;
    private String locationId;
    private String locationName;
    private String description;


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

    public void createSeason(String start_date,String end_date,String name,String description) {
        String sql = "INSERT INTO season(start_date,end_date,name,description) VALUES (?,?,?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, start_date);
            pstmt.setString(2, end_date);
            pstmt.setString(3, name);
            pstmt.setString(4, description);
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


    // ****** MATCH *****

    public void createMatch(String match_date, int season_id,int location_id, int home_team_id, int away_team_id) {
        String sql = "INSERT INTO match(match_date,season_id,location_id,home_team_id,away_team_id) VALUES (?,?,?,?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, match_date);
            pstmt.setInt(2, season_id);
            pstmt.setInt(3, location_id);
            pstmt.setInt(4, home_team_id);
            pstmt.setInt(5, away_team_id);
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


    // ***** PERSON *****
    public void createPerson(String first_name,String last_name,String date_of_birth,int address_id) {
        String sql = "INSERT INTO person(first_name,last_name,date_of_birth,address_id) VALUES (?,?,?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, date_of_birth);
            pstmt.setInt(4, address_id);
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

}
