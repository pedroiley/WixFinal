package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Job {
    private String id;
    private List<List<Data>> data;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("data")
    public List<List<Data>> getData() { return data; }
    @JsonProperty("data")
    public void setData(List<List<Data>> value) { this.data = value; }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", data=" + data +
                '}';
    }
}
