package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;

public class Values {
    private Double number;
    private Boolean valueBoolean;
    private String text;

    @JsonProperty("number")
    public Double getNumber() { return number; }
    @JsonProperty("number")
    public void setNumber(Double value) { this.number = value; }

    @JsonProperty("boolean")
    public Boolean getValueBoolean() { return valueBoolean; }
    @JsonProperty("boolean")
    public void setValueBoolean(Boolean value) { this.valueBoolean = value; }

    @JsonProperty("text")
    public String getText() { return text; }
    @JsonProperty("text")
    public void setText(String value) { this.text = value; }

    @Override
    public String toString() {
        return "Values{" +
                "number=" + number +
                ", valueBoolean=" + valueBoolean +
                ", text='" + text + '\'' +
                '}';
    }
}


