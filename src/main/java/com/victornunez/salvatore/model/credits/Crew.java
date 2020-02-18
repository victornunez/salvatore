package com.victornunez.salvatore.model.credits;

public class Crew {
    private String job;
    private String name;

    public Crew(String job, String name) {
        this.job = job;
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
