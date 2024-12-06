package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import io.sessionservice.common.event.kafka.producer.GenericKafkaSender;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class LoginKafkaSender extends GenericKafkaSender<LoginEvent> {

    private final LoginKafkaProducers strategies;

    public LoginKafkaSender(
            GenericKafkaProducerManager<LoginEvent> kafkaProducerManager, LoginKafkaProducers kafkaProducerStrategies) {
        super(kafkaProducerManager);
        strategies = kafkaProducerStrategies;
    }
}
