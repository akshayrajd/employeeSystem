package com.codebase.employeeSystem.controller;

import com.codebase.employeeSystem.dto.EmployeeDto;
import com.codebase.employeeSystem.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafkaService")
public class MessageController {


    @Autowired
    KafkaProducer kafkaProducer;


    @GetMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestParam String message){
        String result = "Success";
        try{
            kafkaProducer.sendMessage(message);
        } catch (Exception e){
            result = "failure";
            e.printStackTrace();
        }
        return result.equals("Success") ? ResponseEntity.ok("Successfully sent") : ResponseEntity.badRequest().build();
    }

    @PostMapping("/sendJsonMessage")
    public ResponseEntity<String> sendJsonMessage(@RequestBody EmployeeDto employeeDto){
        String result = "Success";
        try{
            kafkaProducer.sendJSONMessage(employeeDto);
        } catch (Exception e){
            result = "failure";
            e.printStackTrace();
        }
        return result.equals("Success") ? ResponseEntity.ok("Successfully sent") : ResponseEntity.badRequest().build();
    }

}
