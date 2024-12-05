package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerStrategy;
import io.sessionservice.common.event.kafka.producer.GenericKafkaSender;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class LoginKafkaSender extends GenericKafkaSender<LoginEvent> {

    public LoginKafkaSender(
            GenericKafkaProducerManager<LoginEvent> kafkaProducerManager) {
        super(kafkaProducerManager);
    }

    @Override
    public void execute(LoginEvent event) {
        GenericKafkaProducerStrategy producer = manager.getProducer(event.getEventType());
        producer.send(event);
    }
}
