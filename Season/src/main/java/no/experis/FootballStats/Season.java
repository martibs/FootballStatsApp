package no.experis.FootballStats;

public class Season {

    private String season_id;
    private String start_date;
    private String end_date;
    private String name;
    private String description;


    public Season(String season_id, String end_date, String name, String description, String start_date) {
        this.season_id = season_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.name = name;
        this.description = description;

    }

    public String getSeason_id() {
        return season_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
