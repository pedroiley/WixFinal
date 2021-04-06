package com.model.formulas;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class If {
    private List<Not> isGreater;
    private String reference;

    @JsonProperty("is_greater")
    public List<Not> getIsGreater() { return isGreater; }
    @JsonProperty("is_greater")
    public void setIsGreater(List<Not> value) { this.isGreater = value; }

    @JsonProperty("reference")
    public String getReference() { return reference; }
    @JsonProperty("reference")
    public void setReference(String value) { this.reference = value; }

    @Override
    public String toString() {
        return "If{" +
                "isGreater=" + isGreater +
                ", reference='" + reference + '\'' +
                '}';
    }
}
