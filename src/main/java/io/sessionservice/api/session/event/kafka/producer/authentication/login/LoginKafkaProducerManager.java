package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducers;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class LoginKafkaProducerManager extends GenericKafkaProducerManager<LoginEvent> {

    public LoginKafkaProducerManager(
            GenericKafkaProducers<LoginEvent> genericKafkaProducerStrategies) {
        super(genericKafkaProducerStrategies);
    }

    @Override
    public void send(LoginEvent event) {
        producers.send(event);
    }
}
