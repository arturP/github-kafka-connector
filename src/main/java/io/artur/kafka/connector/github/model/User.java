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
public class User {

    private String login;
    private Integer id;
    private String avatarUrl;
    private String gravatarId;
    private String url;
    private String htmlUrl;
    private String followersUrl;
    private String followingUrl;
    private String gistsUrl;
    private String starredUrl;
    private String subscriptionsUrl;
    private String organizationsUrl;
    private String reposUrl;
    private String eventsUrl;
    private String receivedEventsUrl;
    private String type;
    private Boolean siteAdmin;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public static User fromJson(JSONObject jsonObject) {
        return new UserBuilder()
                .url(jsonObject.getString(USER_URL_FIELD))
                .htmlUrl(jsonObject.getString(USER_HTML_URL_FIELD))
                .id(jsonObject.getInt(USER_ID_FIELD))
                .login(jsonObject.getString(USER_LOGIN_FIELD))
                .build();
    }
}
