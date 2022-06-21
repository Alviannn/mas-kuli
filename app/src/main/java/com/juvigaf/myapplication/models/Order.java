package com.juvigaf.myapplication.models;

public class Order {

    private Integer money;
    private String orderDate;
    private String teamId;
    private String userId;

    public Order(Integer money, String orderDate, String teamId, String userId) {
        this.money = money;
        this.orderDate = orderDate;
        this.teamId = teamId;
        this.userId = userId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
