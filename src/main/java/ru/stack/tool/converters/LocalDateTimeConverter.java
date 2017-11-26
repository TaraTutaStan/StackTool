package ru.stack.tool.converters;

import org.dozer.DozerConverter;

import java.time.LocalDateTime;

/**
 * Used by dozer for convert LocalDateTime
 */
public class LocalDateTimeConverter extends DozerConverter<LocalDateTime, LocalDateTime> {

    public LocalDateTimeConverter() {
        super(LocalDateTime.class, LocalDateTime.class);
    }

    @Override
    public LocalDateTime convertTo(LocalDateTime source, LocalDateTime destination) {
        return source;
    }

    @Override
    public LocalDateTime convertFrom(LocalDateTime source, LocalDateTime destination) {
        return convertTo(source, destination);
    }
}
