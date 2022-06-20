package io.artur.kafka.connector.github.model;

import lombok.Builder;
import lombok.Data;
import org.json.JSONObject;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.artur.kafka.connector.github.GitHubSchemas.*;

/**
 *
 */
@Data
@Builder
public class Issue {

    private Integer id;
    private String url;
    private String repositoryUrl;
    private String labelsUrl;
    private String commentsUrl;
    private String eventsUrl;
    private String htmlUrl;
    private Integer number;
    private String state;
    private String title;
    private String body;
    private User user;
    private List<Label> labels = null;
    private Assignee
            assignee;
    private Milestone milestone;
    private Boolean locked;
    private Integer comments;
    private PullRequest pullRequest;
    private Object closedAt;
    private Instant createdAt;
    private Instant updatedAt;
    private List<Assignee> assignees = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public static Issue fromJson(JSONObject jsonObject) {

        Issue issue = new IssueBuilder()
                .url(jsonObject.getString(URL_FIELD))
                .htmlUrl(jsonObject.getString(HTML_URL_FIELD))
                .title(jsonObject.getString(TITLE_FIELD))
                .createdAt(Instant.parse(jsonObject.getString(CREATED_AT_FIELD)))
                .updatedAt(Instant.parse(jsonObject.getString(UPDATED_AT_FIELD)))
                .number(jsonObject.getInt(NUMBER_FIELD))
                .state(jsonObject.getString(STATE_FIELD))
                .build();

        // user is mandatory
        User user = User.fromJson(jsonObject.getJSONObject(USER_FIELD));
        issue.setUser(user);

        // pull request is an optional fields
        if (jsonObject.has(PR_FIELD)){
            PullRequest pullRequest = PullRequest.fromJson(jsonObject.getJSONObject(PR_FIELD));
            issue.setPullRequest(pullRequest);
        }

        return issue;
    }
}
