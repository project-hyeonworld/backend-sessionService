package io.sessionservice.api.session.event.kafka.producer.authentication;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerFactory;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerStrategy;
import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Deprecated
public class AuthorizationKafkaProducerFactory extends GenericKafkaProducerFactory<AuthenticationEvent> {

    public AuthorizationKafkaProducerFactory(
            List<GenericKafkaProducerStrategy<? extends AuthenticationEvent, ?, ?>> kafkaConsumerStrategies) {
        super(kafkaConsumerStrategies);
    }
}
