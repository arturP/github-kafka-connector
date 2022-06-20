package io.artur.kafka.connector.github;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class GitHubSourceConnector extends SourceConnector {
  private GitHubSourceConnectorConfig config;

  @Override
  public String version() {
    return VersionUtil.getVersion();
  }

  @Override
  public void start(Map<String, String> map) {
    config = new GitHubSourceConnectorConfig(map);
  }

  @Override
  public Class<? extends Task> taskClass() {
    return GitHubSourceTask.class;
  }

  @Override
  public List<Map<String, String>> taskConfigs(int i) {
    List<Map<String, String>> configs = new ArrayList<>(1);
    configs.add(config.originalsStrings());
    return configs;
  }

  @Override
  public void stop() {
  }

  @Override
  public ConfigDef config() {
    return GitHubSourceConnectorConfig.conf();
  }
}
