package com.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import javax.json.bind.annotation.JsonbProperty;

import org.immutables.value.Value;

@Value.Immutable
public abstract class DataTypes {

    public static enum TYPE {
        TYPE_1,
        TYPE_2
    }

    @JsonbProperty("basic")
    public abstract Basic getBasic();

    @JsonbProperty("specific")
    public abstract Specific getSpecific();

    @JsonbProperty("optionals")
    public abstract Optionals getOptionals();

    @JsonbProperty("list")
    public abstract List<Item> getList();

    @Value.Immutable
    public interface Basic {

        @JsonbProperty("string")
        public abstract String getString();

        @JsonbProperty("character")
        public abstract Character getCharacter();

        @JsonbProperty("byte")
        public abstract Byte getByte();

        @JsonbProperty("short")
        public abstract Short getShort();

        @JsonbProperty("integer")
        public abstract Integer getInteger();

        @JsonbProperty("long")
        public abstract Long getLong();

        @JsonbProperty("float")
        public abstract Float getFloat();

        @JsonbProperty("double")
        public abstract Double getDouble();

        @JsonbProperty("boolean")
        public abstract Boolean isBoolean();

        @JsonbProperty("date")
        public abstract LocalDate getDate();

        @JsonbProperty("dateTime")
        public abstract LocalDateTime getDateTime();

        @JsonbProperty("type")
        public abstract TYPE getType(); 
    }

    @Value.Immutable
    public interface Specific {

        @JsonbProperty("bigInteger")
        public abstract BigInteger getBigInteger();

        @JsonbProperty("bigDecimal")
        public abstract BigDecimal getBigDecimal();

        @JsonbProperty("uri")
        public abstract URI getUri();

        @JsonbProperty("url")
        public abstract URL getUrl();
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
    public interface Item {

        @JsonbProperty("property")
        public abstract String getProperty();

        @JsonbProperty("value")
        public abstract String getValue();
    }
}
