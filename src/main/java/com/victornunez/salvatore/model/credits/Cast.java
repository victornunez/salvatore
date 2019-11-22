package com.victornunez.salvatore.model.credits;

public class Cast {
    private String character;
    private String name;

    public Cast(String character, String name) {
        this.character = character;
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
