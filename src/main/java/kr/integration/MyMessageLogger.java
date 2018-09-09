package kr.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

public class MyMessageLogger implements MessageHandler {

    private Logger log = LoggerFactory.getLogger(MyMessageLogger.class);
    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        log.info("Received message " + message.getPayload().toString());
    }
}
