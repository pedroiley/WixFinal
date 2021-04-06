package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ListAttributes {
    private Values value;
    private Formula formula;

    @JsonProperty("value")
    public Values getValue() { return value; }
    @JsonProperty("value")
    public void setValue(Values value) { this.value = value; }

    @JsonProperty("formula")
    public Formula getFormula() { return formula; }
    @JsonProperty("formula")
    public void setFormula(Formula value) { this.formula = value; }

    @Override
    public String toString() {
        return "ListAttributes{" +
                "value=" + value +
                ", formula=" + formula +
                '}';
    }
}
