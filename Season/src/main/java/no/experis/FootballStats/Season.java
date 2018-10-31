package no.experis.FootballStats;

import java.sql.Date;

public class Season {

    private String season_id;
    private Date start_date;
    private Date end_date;
    private String name;
    private String description;

    public Season(String season_id, Date start_date, Date end_date, String name, String description) {
        this.season_id = season_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.name = name;
        this.description = description;
    }

    public String getSeason_id() {
        return season_id;
    }

    public void setSeason_id(String season_id) {
        this.season_id = season_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
