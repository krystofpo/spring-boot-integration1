package kr.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.io.File;

@Configuration
@EnableIntegration
public class MessagingConfig {


    @Bean
    public MessageChannel httpChannel() {
        return new DirectChannel();
    }


    @Bean
    @ServiceActivator(inputChannel= "httpChannel")
    public MessageHandler httpMessageHandler() {
        return new MyMessageLogger();
    }

}
