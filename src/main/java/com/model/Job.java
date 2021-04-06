package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class Job {
    private String id;
    private List<List<ListAttributes>> data;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("data")
    public List<List<ListAttributes>> getData() { return data; }
    @JsonProperty("data")
    public void setData(List<List<ListAttributes>> value) { this.data = value; }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", data=" + data +
                '}';
    }
}
