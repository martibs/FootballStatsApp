package no.experis.FootballStats.Admin.Models;

public class Watchlist{
    private int watch_id;
    private int user_id;

    public Watchlist() {

    }

    public Watchlist(int watch_id, int user_id) {
        this.watch_id = watch_id;
        this.user_id = user_id;
    }

    public int getWatch_id() {
        return watch_id;
    }

    public int getUser_id() {
        return user_id;
    }
}
