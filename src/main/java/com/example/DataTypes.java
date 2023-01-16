package com.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;

import javax.json.bind.annotation.JsonbProperty;

import org.immutables.value.Value;

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
