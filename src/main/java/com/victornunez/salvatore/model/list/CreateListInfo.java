package com.victornunez.salvatore.model.list;

public class CreateListInfo {
    private String name;
    private String user;

    public CreateListInfo(String user, String name) {
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
