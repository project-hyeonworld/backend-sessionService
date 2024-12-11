package io.sessionservice.api.session.event.kafka.producer.authentication;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerFactory;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Deprecated
public class AuthorizationKafkaProducerFactory extends GenericKafkaProducerFactory<AuthenticationEvent> {

    public AuthorizationKafkaProducerFactory(
            List<GenericKafkaProducer<? extends AuthenticationEvent, ?, ?>> kafkaConsumerStrategies) {
        super(kafkaConsumerStrategies);
    }
}
