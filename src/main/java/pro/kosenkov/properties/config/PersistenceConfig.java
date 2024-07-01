package pro.kosenkov.properties.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "pro.kosenkov.properties.repository")
public class PersistenceConfig {
}
