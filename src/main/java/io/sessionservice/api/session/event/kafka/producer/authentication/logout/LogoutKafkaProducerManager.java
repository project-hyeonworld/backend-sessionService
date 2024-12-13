package io.sessionservice.api.session.event.kafka.producer.authentication.logout;

import io.sessionservice.api.session.event.kafka.producer.authentication.logout.event.LogoutEvent;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class LogoutKafkaProducerManager extends GenericKafkaProducerManager<LogoutEvent> {

    private final GenericKafkaProducer<LogoutEvent, ?, ?> producer;

    public LogoutKafkaProducerManager(GenericKafkaProducer<LogoutEvent, ?, ?> consumer) {
        this.producer = consumer;
    }

    @Override
    public void send(LogoutEvent event) {
        producer.send(event);
    }
}
