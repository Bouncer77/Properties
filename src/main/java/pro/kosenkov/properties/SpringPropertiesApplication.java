package pro.kosenkov.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPropertiesApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringPropertiesApplication.class, args);
        } catch (Throwable t) {
            t.printStackTrace();
            throw t;
        }
    }
}
