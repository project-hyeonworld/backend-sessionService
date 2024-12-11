package io.sessionservice.api.session.event.kafka.producer.authentication;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import io.sessionservice.common.event.kafka.producer.GenericKafkaSender;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Deprecated
public class AuthorizationKafkaSender extends GenericKafkaSender<AuthenticationEvent> {

    public AuthorizationKafkaSender(
            GenericKafkaProducerManager<AuthenticationEvent> kafkaProducerManager) {
        super(kafkaProducerManager);
    }
}
