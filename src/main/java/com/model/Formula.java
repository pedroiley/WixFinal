package com.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.model.formulas.Concat;
import com.model.formulas.If;
import com.model.formulas.Not;

import java.util.List;

public class Formula {
    private String reference;
    private List<Not> sum;
    private List<Not> multiply;
    private List<Not> divide;
    private List<Not> isGreater;
    private List<Not> isEqual;
    private Not not;
    private List<Not> and;
    private List<Not> or;
    private List<If> formulaIf;
    private List<Concat> concat;

    @JsonProperty("reference")
    public String getReference() { return reference; }
    @JsonProperty("reference")
    public void setReference(String value) { this.reference = value; }

    @JsonProperty("sum")
    public List<Not> getSum() { return sum; }
    @JsonProperty("sum")
    public void setSum(List<Not> value) { this.sum = value; }

    @JsonProperty("multiply")
    public List<Not> getMultiply() { return multiply; }
    @JsonProperty("multiply")
    public void setMultiply(List<Not> value) { this.multiply = value; }

    @JsonProperty("divide")
    public List<Not> getDivide() { return divide; }
    @JsonProperty("divide")
    public void setDivide(List<Not> value) { this.divide = value; }

    @JsonProperty("is_greater")
    public List<Not> getIsGreater() { return isGreater; }
    @JsonProperty("is_greater")
    public void setIsGreater(List<Not> value) { this.isGreater = value; }

    @JsonProperty("is_equal")
    public List<Not> getIsEqual() { return isEqual; }
    @JsonProperty("is_equal")
    public void setIsEqual(List<Not> value) { this.isEqual = value; }

    @JsonProperty("not")
    public Not getNot() { return not; }
    @JsonProperty("not")
    public void setNot(Not value) { this.not = value; }

    @JsonProperty("and")
    public List<Not> getAnd() { return and; }
    @JsonProperty("and")
    public void setAnd(List<Not> value) { this.and = value; }

    @JsonProperty("or")
    public List<Not> getOr() { return or; }
    @JsonProperty("or")
    public void setOr(List<Not> value) { this.or = value; }

    @JsonProperty("if")
    public List<If> getFormulaIf() { return formulaIf; }
    @JsonProperty("if")
    public void setFormulaIf(List<If> value) { this.formulaIf = value; }

    @JsonProperty("concat")
    public List<Concat> getConcat() { return concat; }
    @JsonProperty("concat")
    public void setConcat(List<Concat> value) { this.concat = value; }

    public double getTheFormula(double doub, double doub1){
        double result = 0;
        if(getSum() != null){
            result = doub + doub1;

        }
        return result;
    }

    @Override
    public String toString() {
        return "Formula{" +
                "reference='" + reference + '\'' +
                ", sum=" + sum +
                ", multiply=" + multiply +
                ", divide=" + divide +
                ", isGreater=" + isGreater +
                ", isEqual=" + isEqual +
                ", not=" + not +
                ", and=" + and +
                ", or=" + or +
                ", formulaIf=" + formulaIf +
                ", concat=" + concat +
                '}';
    }
}
