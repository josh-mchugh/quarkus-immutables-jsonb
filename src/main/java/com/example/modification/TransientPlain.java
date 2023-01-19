package com.example.modification;

import javax.json.bind.annotation.JsonbTransient;

public class TransientPlain {
 
    @JsonbTransient
    private String transientAnnotation;

    private transient String transientModifier;

    private String nonTransient;

    public String getTransientAnnotation() {
        return transientAnnotation;
    }

    public void setTransientAnnotation(String transientAnnotation) {
        this.transientAnnotation = transientAnnotation;
    }

    public String getTransientModifier() {
        return transientModifier;
    }

    public void setTransientModifier(String transientModifier) {
        this.transientModifier = transientModifier;
    }

    public String getNonTransient() {
        return nonTransient;
    }

    public void setNonTransient(String nonTransient) {
        this.nonTransient = nonTransient;
    }
}
