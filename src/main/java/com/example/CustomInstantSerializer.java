package com.example;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CustomInstantSerializer extends JsonSerializer<Instant>
{
    private final ObjectMapper jsonMapper = new ObjectMapper();

    @Override
    public void serialize(Instant value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
        if (null == value) {
            //write the word 'null' if there's no value available
            jgen.writeNull();
        } else {
            LocalDateTime localDateTime = value.atZone(ZoneId.of(ZoneId.SHORT_IDS.get("IST"))).toLocalDateTime();
            jsonMapper.writeValue(jgen,localDateTime);
        }
    }
}

