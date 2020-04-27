package com.cheer.activemqdemo.producer;

import com.cheer.activemqdemo.vo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") final String message) {
        LOGGER.info("Produced message='{}'", message);
        jmsTemplate.convertAndSend("testing-message.queue", message);
        return "Published successfully";
    }

    @PostMapping("/student")
    public ResponseEntity<String> getStudent(@RequestBody Student student) {
        LOGGER.info("Produced student's name='{}'", student.getName());
        jmsTemplate.convertAndSend("testing-student.queue", student);
        return new ResponseEntity<String>("Published successfully", HttpStatus.OK);
    }
}
