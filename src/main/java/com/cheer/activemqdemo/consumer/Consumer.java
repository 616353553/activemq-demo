package com.cheer.activemqdemo.consumer;

import com.cheer.activemqdemo.vo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination="testing-message.queue")
    public void consumeMessage(String message) {
        LOGGER.info("Received message='{}'", message);
    }

    @JmsListener(destination="testing-student.queue")
    public void consumeStudent(Student student) {
        LOGGER.info("Received student's name='{}'", student.getName());
    }
}
