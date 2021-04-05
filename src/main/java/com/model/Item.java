package com.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class Item {
    private String id;
    private List<List<LinkedHashMap<String, LinkedHashMap<String, Object>>>> data = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<List<LinkedHashMap<String, LinkedHashMap<String, Object>>>> getData() {
        return data;
    }

    public void setData(List<List<LinkedHashMap<String, LinkedHashMap<String, Object>>>> data) {
        this.data = data;
    }
}
