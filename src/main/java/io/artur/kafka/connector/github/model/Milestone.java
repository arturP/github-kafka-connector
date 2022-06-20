package io.artur.kafka.connector.github.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Data
public class Milestone {

    private String url;
    private String htmlUrl;
    private String labelsUrl;
    private Integer id;
    private Integer number;
    private String state;
    private String title;
    private String description;
    private Creator creator;
    private Integer openIssues;
    private Integer closedIssues;
    private String createdAt;
    private String updatedAt;
    private String closedAt;
    private String dueOn;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


}
