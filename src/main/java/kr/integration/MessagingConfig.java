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

    public String INPUT_DIR = "the_source_dir";
    public String OUTPUT_DIR = "the_dest_dir";
    public String FILE_PATTERN = "*.mpeg";

    @Bean
    public MessageChannel httpChannel() {
        return new DirectChannel();
    }

//    @Bean
//    @InboundChannelAdapter(value = "httpChannel", poller = @Poller(fixedDelay = "1000"))
//    public MessageSource<File> fileReadingMessageSource() {
//        FileReadingMessageSource sourceReader= new FileReadingMessageSource();
//        sourceReader.setDirectory(new File(INPUT_DIR));
//        sourceReader.setFilter(new SimplePatternFileListFilter(FILE_PATTERN));
//        return sourceReader;
//    }

    @Bean
    @ServiceActivator(inputChannel= "httpChannel")
    public MessageHandler httpMessageHandler() {
        return new MyMessageLogger();
    }
}
