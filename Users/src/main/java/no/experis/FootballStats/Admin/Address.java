package no.experis.FootballStats.Admin;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data

public class Address {


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

    public Address(String address_id, String address_line_1, String address_line_2, String address_line_3, String postal_code, String city, String country, String location_id, String location_name, String description) {
        this.address_id = address_id;
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.address_line_3 = address_line_3;
        this.postal_code = postal_code;
        this.city = city;
        this.country = country;
        this.location_id = location_id;
        this.location_name = location_name;
        this.description = description;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }
}