package com.model.formulas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Not {
    private String reference;

    @JsonProperty("reference")
    public String getReference() { return reference; }
    @JsonProperty("reference")
    public void setReference(String value) { this.reference = value; }

    @Override
    public String toString() {
        return "Not{" +
                "reference='" + reference + '\'' +
                '}';
    }
}