package io.artur.kafka.connector.github.validators;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigException;

import java.time.Instant;
import java.time.format.DateTimeParseException;

/**
 *
 */
public class TimestampValidator implements ConfigDef.Validator {
    @Override
    public void ensureValid(String name, Object value) {
        String timestamp = (String) value;
        try{
            Instant.parse(timestamp);
        } catch (DateTimeParseException ex) {
            throw new ConfigException(name, value, "Unable to parse timestamp provided.");
        }
    }
}
