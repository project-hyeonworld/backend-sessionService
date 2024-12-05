package io.sessionservice.api.session.event.kafka.producer.authentication;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerFactory;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Deprecated
public class AuhorizationKafkaProducerManager extends GenericKafkaProducerManager<AuthenticationEvent> {

    public AuhorizationKafkaProducerManager(
            GenericKafkaProducerFactory<AuthenticationEvent> genericKafkaConsumerFactory) {
        super(genericKafkaConsumerFactory);
    }
}
