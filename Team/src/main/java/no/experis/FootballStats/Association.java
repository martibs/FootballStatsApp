package no.experis.FootballStats;

public class Association {

    private String association_id;
    private String association_name;
    private String association_description;

    public Association(String association_id, String association_name, String association_description) {
        this.association_id = association_id;
        this.association_name = association_name;
        this.association_description = association_description;
    }


    public String getAssociation_id() {
        return association_id;
    }

    public void setAssociation_id(String association_id) {
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


