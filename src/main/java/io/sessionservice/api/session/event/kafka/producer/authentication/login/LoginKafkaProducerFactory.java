package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerFactory;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Deprecated
public class LoginKafkaProducerFactory extends GenericKafkaProducerFactory<LoginEvent> {

    public LoginKafkaProducerFactory(
            List<GenericKafkaProducer<? extends LoginEvent, ?, ?>> kafkaConsumerStrategies) {
        super(kafkaConsumerStrategies);
    }

}


