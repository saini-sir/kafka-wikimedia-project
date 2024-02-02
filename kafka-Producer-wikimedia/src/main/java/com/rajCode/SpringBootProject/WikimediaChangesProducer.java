package com.rajCode.SpringBootProject;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducer {

//    private final Logger logger = LoggerFactory.getLogger(WikimediaChangesProducer.class);
    private final KafkaTemplate<String,String> kafkaTemplate;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public  void sendMessage() throws  InterruptedException{
        String topic = "Wikimedia_Recent_changes";
        // to read real time stream data from wikimedia , we use event source
        EventHandler evenHandler = new WikimediaChangesHandler(kafkaTemplate,topic);
        String  url  = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(evenHandler, URI.create(url));
        EventSource eventSoruce = builder.build();
        eventSoruce.start();

        TimeUnit.SECONDS.sleep(120);
    }
}
