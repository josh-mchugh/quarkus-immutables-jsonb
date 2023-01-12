package com.example;

import javax.json.bind.annotation.JsonbProperty;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Greeting {

    @JsonbProperty("message")
    public abstract String getMessage();
}
