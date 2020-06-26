package com.example.kyrsovaya_client_v2.models;

import java.util.List;

public class Stat {
    private String login;
    private String statistics;
    private List<Stat> stat;

    public Stat(String login, String statistics){
        this.login = login;
        this.statistics = statistics;
    }

    public String getLogin() {
        return login;
    }

    public String getStatistics() {
        return statistics;
    }

    public List<Stat> getStat() {
        return stat;
    }
}
