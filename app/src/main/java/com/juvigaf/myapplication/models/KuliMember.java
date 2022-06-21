package com.juvigaf.myapplication.models;

import java.util.List;

public class KuliMember {

    private String teamId;
    private List<User>users;
    private Double rating;

    public KuliMember(String teamId, List<User> users, Double rating) {
        this.teamId = teamId;
        this.users = users;
        this.rating = rating;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
