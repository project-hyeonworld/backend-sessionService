package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerFactory;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerStrategy;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class LoginKafkaProducerFactory extends GenericKafkaProducerFactory<LoginEvent> {

    public LoginKafkaProducerFactory(
            List<GenericKafkaProducerStrategy<? extends LoginEvent, ?, ?>> kafkaConsumerStrategies) {
        super(kafkaConsumerStrategies);
    }

}


