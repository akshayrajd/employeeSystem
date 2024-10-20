package com.codebase.employeeSystem.configuration;

import com.codebase.employeeSystem.constants.AppConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    public NewTopic codeBaseTopic(){
        return TopicBuilder.name(AppConstants.KAFKA_DEFAULT_TOPIC_NAME).build();
    }

    public NewTopic codeBaseJsonTopic(){
        return TopicBuilder.name(AppConstants.KAFKA_JSON_TOPIC_NAME).build();
    }
}
