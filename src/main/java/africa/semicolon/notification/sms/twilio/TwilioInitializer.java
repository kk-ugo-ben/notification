package africa.semicolon.notification.sms.twilio;

import com.twilio.Twilio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class TwilioInitializer {

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioInitializer(TwilioConfiguration twilioConfiguration){
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());
        log.info("Twilio account sid id {} ", twilioConfiguration.getAccountSid());
    }
}