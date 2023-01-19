package com.example.modification;

import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransientTest {
    
    @Test
    public void whenImmutableThenExpectJSON() {

        String expected = "{\"nonTransient\":\"show\",\"transientAnnotation\":\"hide\"}";

        Transient immutable = ImmutableTransient.builder()
            .transientAnnotation("hide")
            .nonTransient("show")
            .build();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(immutable));
    }

    @Test
    public void whenPlanJavaObjectThenExpectJSON() {

        String expected = "{\"nonTransient\":\"show\"}";

        TransientPlain plain = new TransientPlain();
        plain.setTransientAnnotation("hide");
        plain.setTransientModifier("hide");
        plain.setNonTransient("show");

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(plain));
    }
}
