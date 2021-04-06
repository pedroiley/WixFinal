package com.model.formulas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConcatValue {
    private String text;

    @JsonProperty("text")
    public String getText() { return text; }
    @JsonProperty("text")
    public void setText(String value) { this.text = value; }

    @Override
    public String toString() {
        return "ConcatValue{" +
                "text='" + text + '\'' +
                '}';
    }
}
