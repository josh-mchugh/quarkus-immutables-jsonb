package com.example.modification;

import javax.json.bind.annotation.JsonbTransient;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Transient {
    
    @JsonbTransient
    public abstract String getTransientAnnotation();

    public abstract String getNonTransient();
}
