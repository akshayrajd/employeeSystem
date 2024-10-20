package com.codebase.employeeSystem.kafka;

import com.codebase.employeeSystem.constants.AppConstants;
import com.codebase.employeeSystem.dto.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, EmployeeDto> kafkaJsonTemplate;

    public void sendMessage(String msg){
        logger.info("Sending message {} ",msg);
        kafkaTemplate.send(AppConstants.KAFKA_DEFAULT_TOPIC_NAME,msg);
    }

    public void sendJSONMessage(EmployeeDto employeeDto){
        logger.info("Sending JSON message {} ",employeeDto.toString());
        Message<EmployeeDto> message = MessageBuilder.withPayload(employeeDto)
                .setHeader(KafkaHeaders.TOPIC, AppConstants.KAFKA_JSON_TOPIC_NAME)
                .build();
        kafkaJsonTemplate.send(message);
    }

}
