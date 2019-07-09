package com.simplon.enigma.model;

import javax.persistence.AttributeConverter;

public class BooleanConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return Boolean.TRUE.equals(attribute) ? "T" : "F";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "T".equals(dbData);
    }
}
