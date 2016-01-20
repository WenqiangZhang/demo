package com.it1224.demos.psretrofit.entity;

/**
 * Created by lenovo on 2016/1/15.
 */
public class Contributor {

    private String login;
    private int contributions;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getContributions() {
        return contributions;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
    }

    @Override
    public String toString() {
        return login + ", " + contributions;
    }
}
