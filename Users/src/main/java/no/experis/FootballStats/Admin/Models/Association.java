package no.experis.FootballStats.Admin.Models;

public class Association {

    private int association_id;
    private String association_name;
    private String association_description;

    public Association(){

    }

    public Association(int association_id, String association_name, String association_description) {
        this.association_id = association_id;
        this.association_name = association_name;
        this.association_description = association_description;
    }

    public int getAssociation_id() {
        return association_id;
    }

    public void setAssociation_id(int association_id) {
        this.association_id = association_id;
    }

    public String getAssociation_name() {
        return association_name;
    }

    public void setAssociation_name(String association_name) {
        this.association_name = association_name;
    }

    public String getAssociation_description() {
        return association_description;
    }

    public void setAssociation_description(String association_description) {
        this.association_description = association_description;
    }
}
