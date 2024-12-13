package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.api.session.event.kafka.producer.authentication.login.event.LoginEvent;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class LoginKafkaProducerManager extends GenericKafkaProducerManager<LoginEvent> {

    private final GenericKafkaProducer<LoginEvent, ?, ?> producer;

    public LoginKafkaProducerManager(
            GenericKafkaProducer<LoginEvent, ?, ?> loginKafkaProducer) {
        producer = loginKafkaProducer;
    }

    @Override
    public void send(LoginEvent event) {
        producer.send(event);
    }
}
