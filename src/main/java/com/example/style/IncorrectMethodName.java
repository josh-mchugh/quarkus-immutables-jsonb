package com.example.style;

import javax.json.bind.annotation.JsonbProperty;

import org.immutables.value.Value;

@Value.Immutable
public abstract class IncorrectMethodName {

    @JsonbProperty("value")
    public abstract String value();
}
