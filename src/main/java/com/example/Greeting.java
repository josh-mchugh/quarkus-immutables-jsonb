package com.example;

import javax.json.bind.annotation.JsonbAnnotation;
import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbNumberFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.json.bind.annotation.JsonbTypeDeserializer;
import javax.json.bind.annotation.JsonbTypeSerializer;
import javax.json.bind.annotation.JsonbVisibility;

import org.immutables.value.Value;
import org.immutables.value.Value.Style;

import immutables.jsonb.ImmutableJsonb;

/*@Value.Immutable
@Style(
    defaultAsDefault = true,
    typeBuilder = "*InternalBuilder",
    implementationNestedInBuilder = true,
    validationMethod = Style.ValidationMethod.NONE,
    jacksonIntegration = false,
    of = "new",
    allParameters = true,
    passAnnotations = {
        JsonbAnnotation.class,
        JsonbCreator.class,
        JsonbDateFormat.class,
        JsonbNillable.class,
        JsonbNumberFormat.class,
        JsonbProperty.class,
        JsonbPropertyOrder.class,
        JsonbTransient.class,
        JsonbTypeAdapter.class,
        JsonbTypeSerializer.class,
        JsonbTypeDeserializer.class,
        JsonbVisibility.class
    },
    jdkOnly = true
)*/
@ImmutableJsonb
public abstract class Greeting {
    
    @JsonbCreator
    public Greeting() {

    }

    @JsonbProperty("message")
    public abstract String message();
}
