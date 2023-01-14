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

        @JsonbProperty("date")
        public LocalDate getDate();

        @JsonbProperty("dateTime")
        public LocalDateTime getDateTime();

        @JsonbProperty("type")
        public TYPE getType(); 
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
    public interface Item {

        @JsonbProperty("property")
        public String getProperty();

        @JsonbProperty("value")
        public String getValue();
    }
}
