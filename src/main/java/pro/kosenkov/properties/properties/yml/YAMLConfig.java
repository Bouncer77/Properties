package pro.kosenkov.properties.properties.yml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Data
public class YAMLConfig {

    private String name;

    private Component component = new Component();

    private List<String> servers = new ArrayList<>();

    @Data
    public class Component {
        private Service service = new Service();
    }

    @Data
    public class Service {
        private String url;
        private String token;
        private String description;
    }


}
