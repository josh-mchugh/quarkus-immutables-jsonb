# Quarkus + Immutables + Jsonb Project

This is a simple project to test the compatibility of Jsonb and Immutables libraries. I recently encountered some issues within my project [quarkus-restful-bagel-app](https://github.com/josh-mchugh/quarkus-restful-bagel-app) when using Jsonb and Immutables.

## Issue

The issue appeared to be when using Immutables + Jsonb. If you do not name your Immutables accessor methods correctly, they will return an empty JSON object.

The Immutables class and unit test below demonstrate this issue.

Immutables Class
```java
package com.example.style;

import javax.json.bind.annotation.JsonbProperty;

import org.immutables.value.Value;

@Value.Immutable
public abstract class IncorrectMethodName {

    @JsonbProperty("value")
    public abstract String value();
}
```

Unit Test
```java
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
```

## Fix

I stumbled across a [Github issue](https://github.com/immutables/immutables/issues/708) and [Stackoverflow post](https://stackoverflow.com/a/53741517) that give insight into making Immutables and Jsonb work well enough to provide a properly formatted response.

Prefixing the Immutables accessors with `get` helps Jsonb correctly generate a proper JSON response. This is the default functionality for Immutables so there is no need for special styles or overrides.

The example below would solve the issues demonstrated above.

```java
package com.example.style;

import javax.json.bind.annotation.JsonbProperty;

import org.immutables.value.Value;

@Value.Immutable
public abstract class IncorrectMethodName {

    @JsonbProperty("value")
    public abstract String getValue();
}
```

## Jsonb Standards

During this experiment, I found a nice power point detailing the different data types of Jsonb and comparisons with other JSON libraries. I wanted to incorporate this into my project to understand more about Jsonb and its JSON output.

I created a DataTypes object that contained as many data types as reflected my day-to-day tasks. I generated tests to verify the JSON and tested it with Quarkus to see how it would be handled and how the REST Assured would handle the data within its assertions.

One data type to point out that got formatted well was the dates. When compared to other JSON serializers, the Jsonb format is really easy to read as it is a string value. Nothing more, nothing less. Another thing to notice is the dates types. `Date` and `Calendar` formatted strings are a lot harder to read than the `LocalDate` and `LocalDateTime`. I found this quite interesting. It is another good reason to keep reminding ourselves and other developers to use `LocalDate` and `LocalDateTime` over `Date` and `Calendar`.

Jsonb Powerpoint
https://de.slideshare.net/DmitryKornilov/jsonb-introduction-and-comparison-with-other-frameworks

DataTypes class
```java
@Value.Immutable
public abstract class DataTypes {

    @JsonbProperty("basic")
    public abstract Basic getBasic();

    @JsonbProperty("specific")
    public abstract Specific getSpecific();

    @JsonbProperty("optionals")
    public abstract Optionals getOptionals();

    @JsonbProperty("dates")
    public abstract Dates getDates();

    @JsonbProperty("enumeration")
    public abstract Enumeration getEnumeration();

    @JsonbProperty("collections")
    public abstract Collections getCollections();

    @Value.Immutable
    public interface Basic {

        @JsonbProperty("string")
        public String getString();

        @JsonbProperty("character")
        public Character getCharacter();

        @JsonbProperty("byte")
        public Byte getByte();

        @JsonbProperty("short")
        public Short getShort();

        @JsonbProperty("integer")
        public Integer getInteger();

        @JsonbProperty("long")
        public Long getLong();

        @JsonbProperty("float")
        public Float getFloat();

        @JsonbProperty("double")
        public Double getDouble();

        @JsonbProperty("boolean")
        public Boolean isBoolean();
    }

    @Value.Immutable
    public interface Specific {

        @JsonbProperty("bigInteger")
        public BigInteger getBigInteger();

        @JsonbProperty("bigDecimal")
        public BigDecimal getBigDecimal();

        @JsonbProperty("uri")
        public URI getUri();

        @JsonbProperty("url")
        public URL getUrl();
    }

    @Value.Immutable
    public interface Optionals {

        @JsonbProperty("optional")
        public Optional<String> getOptional();

        @JsonbProperty("optionalInt")
        public OptionalInt getOptionalInt();

        @JsonbProperty("optionalLong") 
        public OptionalLong getOptionalLong();
        
        @JsonbProperty("optionalDouble")
        public OptionalDouble getOptionalDouble();
    }

    @Value.Immutable
    public interface Dates {

        @JsonbProperty("date")
        public Date getDate();

        @JsonbProperty("calendar")
        public Calendar getCalendar();

        @JsonbProperty("localTime")
        public LocalTime getLocalTime();

        @JsonbProperty("localDate")
        public LocalDate getLocalDate();

        @JsonbProperty("localDateTime")
        public LocalDateTime getLocalDateTime();
    }

    @Value.Immutable
    public interface Enumeration {

        public static enum EnumType {
            TYPE_1,
            TYPE_2
        }

        @JsonbProperty("enumType") 
        public EnumType getEnumType();
    }

    @Value.Immutable
    public interface Collections {

        @JsonbProperty("listValues")
        public List<String> getListValues();

        @JsonbProperty("setValues")
        public Set<String> getSetValues();

        @JsonbProperty("mapValues")
        public Map<String, String> getMapValues();
    }
}
```
Output JSON
```json
{
    "basic": {
        "boolean": false,
        "byte": 1,
        "character": "A",
        "double": 0.9999,
        "float": 0.999,
        "integer": 1337,
        "long": 999,
        "short": 1,
        "string": "String - Test"
    },
    "collections": {
        "listValues": [
            "List Value - 1"
        ],
        "mapValues": {
            "Key1": "Value - 1"
        },
        "setValues": [
            "Set Value - 1"
        ]
    },
    "dates": {
        "calendar": "2023-01-14T12:00:00-05:00[America/New_York]",
        "date": "2023-01-14T17:00:00Z[UTC]",
        "localDate": "2023-01-14",
        "localDateTime": "2023-01-14T12:00:00",
        "localTime": "12:00:00"
    },
    "enumeration": {
        "enumType": "TYPE_1"
    },
    "optionals": {
        "optional": "Hello, Optional",
        "optionalDouble": 0.999,
        "optionalInt": 1337,
        "optionalLong": 999
    },
    "specific": {
        "bigDecimal": 0.999,
        "bigInteger": 1337,
        "uri": "http://www.quarkus.io",
        "url": "http://www.quarkus.io"
    }
}
```

## Additional Test Project

Testing Jsonb & Immutables with Quarkus native builds. [Git Project](https://github.com/josh-mchugh/quarkus-jsonb-immutables-native)

This was not part of the original experiment and has been set up in a separate project. 

## Summary

While Immutables and Jsonb can work together, the support for Jackson JSON and Immutables is [more developed](https://immutables.github.io/json.html#overview). This better support would cause me to lean towards using Jackson JSON when working with Immutables and JSON serialization and deserialization.

I look forward to the day Jsonb is more compatible with Immutables.




### Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.
