package com.rajCode.SpringBootProject;

import ch.qos.logback.core.joran.action.NewRuleAction;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {


    @Bean
    public NewTopic topic(){
        return TopicBuilder.name("Wikimedia_Recent_changes")
                .build();
    }
}
