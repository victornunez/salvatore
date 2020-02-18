package com.victornunez.salvatore.connector.dto.credits;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrewDTO {
    @JsonProperty("credit_id") private String creditId;
    private String department;
    private String job;
    private String name;

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
