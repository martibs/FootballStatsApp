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

    private String address_id;
    private String address_line_1;
    private String address_line_2;
    private String address_line_3;
    private String postal_code;
    private String city;
    private String country;
    private String location_id;
    private String location_name;
    private String description;


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

    public ArrayList<Address> getAddresses() {
        String sql = "SELECT * FROM LOCATION INNER JOIN ADDRESS ON ADDRESS.ADDRESS_ID = LOCATION.ADDRESS_ID";

        Address tempAddress = null;
        ArrayList<Address> tempAddressList = new ArrayList<Address>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                address_id = Integer.toString(rs.getInt("ADDRESS_ID"));
                address_line_1 = rs.getString("address_line_1");
                address_line_2 = rs.getString("address_line_2");
                address_line_3 = rs.getString("address_line_3");
                postal_code = rs.getString("POSTAL_CODE");
                city = rs.getString("CITY");
                country = rs.getString("COUNTRY");
                location_id = rs.getString("LOCATION_ID");
                location_name = rs.getString("NAME");
                description = rs.getString("DESCRIPTION");

                tempAddress = new Address(address_id, address_line_1, address_line_2, address_line_3, postal_code, city, country, location_id,location_name,description);
                tempAddressList.add(tempAddress);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempAddressList;
    }


}
