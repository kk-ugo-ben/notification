package africa.semicolon.notification.config.maildev;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class MailDevConfiguration {
    private String host;
    private int port;
    private String username;
    private String password;


}
