package com.model.formulas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Concat {
    private ConcatValue value;


    @JsonProperty("value")
    public ConcatValue getValue() { return value; }
    @JsonProperty("value")
    public void setValue(ConcatValue value) { this.value = value; }

    @Override
    public String toString() {
        return "Concat{" +
                "value=" + value +
                '}';
    }
}
