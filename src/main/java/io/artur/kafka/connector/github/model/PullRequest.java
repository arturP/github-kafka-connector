package io.artur.kafka.connector.github.model;

import lombok.Builder;
import lombok.Data;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.artur.kafka.connector.github.GitHubSchemas.*;

/**
 *
 */
@Data
@Builder
public class PullRequest {

    private String url;
    private String htmlUrl;
    private String diffUrl;
    private String patchUrl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public static PullRequest fromJson(JSONObject pull_request) {
        return new PullRequestBuilder()
                .url(pull_request.getString(PR_URL_FIELD))
                .htmlUrl(pull_request.getString(PR_HTML_URL_FIELD))
                .build();

    }
}
