package com.victornunez.salvatore.model.list;

public class CreationListInfo {
    private String name;
    private String user;

    public CreationListInfo(String user, String name) {
        this.user = user;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }
}
