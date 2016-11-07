package com.ironyard.movies.dto;

/**
 * Created by jasonskipper on 10/26/16.
 */
public class FifaTeam {
    private String country;
    private String alternate_name;
    private String fifa_code;
    private long group_id;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAlternate_name() {
        return alternate_name;
    }

    public void setAlternate_name(String alternate_name) {
        this.alternate_name = alternate_name;
    }

    public String getFifa_code() {
        return fifa_code;
    }

    public void setFifa_code(String fifa_code) {
        this.fifa_code = fifa_code;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }
}
