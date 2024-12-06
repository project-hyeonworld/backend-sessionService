package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class LoginKafkaProducerManager extends GenericKafkaProducerManager<LoginEvent> {

    public LoginKafkaProducerManager(
            LoginKafkaProducers genericKafkaProducerStrategies) {
        super(genericKafkaProducerStrategies);
    }

    @Override
    public void send(LoginEvent event) {
        strategies.send(event);
    }
}
