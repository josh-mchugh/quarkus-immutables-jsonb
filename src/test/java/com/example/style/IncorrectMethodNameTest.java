package com.example.style;

import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.ImmutableIncorrectMethodName;

public class IncorrectMethodNameTest {
    
    @Test
    public void whenInncorrectMethodNameThenExpectEmptyJSONObject() {

        String expected = "{}";

        IncorrectMethodName incorrectMethodName = ImmutableIncorrectMethodName.builder()
            .value("test")
            .build();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(incorrectMethodName));
    }
}
