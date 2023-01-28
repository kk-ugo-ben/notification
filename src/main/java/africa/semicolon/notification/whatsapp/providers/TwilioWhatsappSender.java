package africa.semicolon.notification.whatsapp.providers;

import africa.semicolon.notification.config.twilio.TwilioConfiguration;
import africa.semicolon.notification.dtos.requests.MessageRequest;
import africa.semicolon.notification.utils.SendType;
import africa.semicolon.notification.whatsapp.WhatsappRequest;
import africa.semicolon.notification.whatsapp.WhatsappService;
import africa.semicolon.notification.whatsapp.mapper.WhatsappModelMapper;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TwilioWhatsappSender implements WhatsappService {

    private final TwilioConfiguration twilioConfiguration;
    private final WhatsappModelMapper mapper;

    @Override
    public SendType getType() {
        return SendType.WHATSAPP;
    }

    @Override
    public void send(MessageRequest messageRequest) {
        WhatsappRequest whatsappRequest = mapper.map(messageRequest);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:"+whatsappRequest.getPhoneNumber()),
                        new com.twilio.type.PhoneNumber("whatsapp:"+twilioConfiguration.getWhatsappTrialNumber()),
                        whatsappRequest.getMessage())
                .create();

        log.info("Whatsapp Message Id {} ", message.getSid());
    }
}