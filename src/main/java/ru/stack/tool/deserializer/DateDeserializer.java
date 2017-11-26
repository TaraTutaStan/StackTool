package ru.stack.tool.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Deserializer for json node which contains seconds in LocalDateTime
 */
public class DateDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext arg1) throws IOException {
        String secDataString = jsonParser.getText();

        if (secDataString == null || secDataString.length() == 0)
            return null;

        return Instant.ofEpochMilli(Long.valueOf(secDataString) * 1000).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}