package com.codebase.employeeSystem.kafka;

import com.codebase.employeeSystem.constants.AppConstants;
import com.codebase.employeeSystem.dto.EmployeeDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = AppConstants.KAFKA_DEFAULT_TOPIC_NAME, groupId = "myGroup")
    public void consumeDefault(String message){
        System.out.println("Received message "+ message);
    }
    @KafkaListener(topics = AppConstants.KAFKA_JSON_TOPIC_NAME, groupId = "myGroup")
    public void consumeJson(EmployeeDto employeeDto){
        System.out.println("Received JSON message "+ employeeDto.toString());
    }

}
