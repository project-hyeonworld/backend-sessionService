package io.sessionservice.api.session.event.kafka.producer.authentication.logout;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerFactory;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerStrategy;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class LogoutKafkaProducerFactory extends GenericKafkaProducerFactory<LogoutEvent> {

    public LogoutKafkaProducerFactory(
            List<GenericKafkaProducerStrategy<? extends LogoutEvent, ?, ?>> kafkaConsumerStrategies) {
        super(kafkaConsumerStrategies);
    }
}
