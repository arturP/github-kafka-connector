package io.artur.kafka.connector.github.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Data
public class Label {

    private Integer id;
    private String url;
    private String name;
    private String color;
    private Boolean _default;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
