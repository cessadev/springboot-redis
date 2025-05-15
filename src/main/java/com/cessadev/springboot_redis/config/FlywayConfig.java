package com.cessadev.springboot_redis.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class FlywayConfig {

  @Value("${spring.flyway.url}")
  private String flywayUrl;

  @Value("${spring.flyway.user}")
  private String flywayUser;

  @Value("${spring.flyway.password}")
  private String flywayPassword;

  @Value("${spring.flyway.schemas}")
  private String[] schemas;

  private Flyway flyway;

  @Bean
  @Profile("dev")
  public FlywayMigrationStrategy cleanMigrateStrategy() {
    return flyway -> {
      this.flyway = buildCustomFlyway();
      this.flyway.clean();
      this.flyway.migrate();
    };
  }

  @Bean
  @Profile("!dev")
  public FlywayMigrationStrategy productionMigrationStrategy() {
    return flyway -> {
      this.flyway = buildCustomFlyway();
      this.flyway.migrate();
    };
  }

  private Flyway buildCustomFlyway() {
    FluentConfiguration configuration = Flyway.configure()
            .dataSource(flywayUrl, flywayUser, flywayPassword)
            .schemas(schemas)
            .cleanDisabled(false)
            .baselineOnMigrate(true);

    return new Flyway(configuration);
  }

}
