package no.experis.FootballStats.Admin.Models;

public class Address {

    private String address_id;
    private String address_line_1;
    private String address_line_2;
    private String address_line_3;
    private String postal_code;
    private String city;
    private String country;
    private int location_id;
    private String name;
    private String description;

    public Address(){

    }

    public Address(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Address(String address_line_1, String address_line_2, String address_line_3, String postal_code, String city, String country) {
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.address_line_3 = address_line_3;
        this.postal_code = postal_code;
        this.city = city;
        this.country = country;
    }

    public Address(String address_line_1, String address_line_2, String address_line_3, String postal_code, String city, String country, int location_id, String name, String description) {
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.address_line_3 = address_line_3;
        this.postal_code = postal_code;
        this.city = city;
        this.country = country;
        this.location_id = location_id;
        this.name = name;
        this.description = description;
    }

    public Address(String address_id, String address_line_1, String address_line_2, String address_line_3, String postal_code, String city, String country) {
        this.address_id = address_id;
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.address_line_3 = address_line_3;
        this.postal_code = postal_code;
        this.city = city;
        this.country = country;
    }

    public Address(String address_line_1, String address_line_2, String address_line_3, String postal_code, String city, String country, String name, String description) {
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.address_line_3 = address_line_3;
        this.postal_code = postal_code;
        this.city = city;
        this.country = country;
        this.name = name;
        this.description = description;
    }


    public String getAddress_id() {
        return address_id;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public String getAddress_line_3() {
        return address_line_3;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public void setAddress_line_3(String address_line_3) {
        this.address_line_3 = address_line_3;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLocation_id() {
        return location_id;
    }
}