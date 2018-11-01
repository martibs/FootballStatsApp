package no.experis.FootballStats.Admin.Models;

public class Contact {

    private int contact_id;
    private int person_id;
    private String contact_type;
    private String contact_detail;

    public Contact(){

    }

    public Contact(int contact_id, int person_id, String contact_type, String contact_detail) {
        this.contact_id = contact_id;
        this.person_id = person_id;
        this.contact_type = contact_type;
        this.contact_detail = contact_detail;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getContact_type() {
        return contact_type;
    }

    public void setContact_type(String contact_type) {
        this.contact_type = contact_type;
    }

    public String getContact_detail() {
        return contact_detail;
    }

    public void setContact_detail(String contact_detail) {
        this.contact_detail = contact_detail;
    }
}
