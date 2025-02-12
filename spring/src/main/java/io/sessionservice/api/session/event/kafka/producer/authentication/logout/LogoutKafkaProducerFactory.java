package io.sessionservice.api.session.event.kafka.producer.authentication.logout;

import io.sessionservice.api.session.event.kafka.producer.authentication.logout.event.LogoutEvent;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerFactory;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class LogoutKafkaProducerFactory extends GenericKafkaProducerFactory<LogoutEvent> {

    public LogoutKafkaProducerFactory(
            List<GenericKafkaProducer<? extends LogoutEvent, ?, ?>> kafkaConsumerStrategies) {
        super(kafkaConsumerStrategies);
    }
}
