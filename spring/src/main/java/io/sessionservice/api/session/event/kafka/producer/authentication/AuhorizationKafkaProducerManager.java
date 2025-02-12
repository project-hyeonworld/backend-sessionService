package io.sessionservice.api.session.event.kafka.producer.authentication;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducers;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Deprecated
public class AuhorizationKafkaProducerManager extends GenericKafkaProducerManager<AuthenticationEvent> {

    public AuhorizationKafkaProducerManager(
            GenericKafkaProducers<AuthenticationEvent> genericKafkaProducers) {
        //super(genericKafkaProducers);
    }

    @Override
    public void send(AuthenticationEvent event) {

    }
}
