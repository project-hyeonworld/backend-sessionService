package io.sessionservice.api.session.event.kafka.producer.ingame.exitGame;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerFactory;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerStrategy;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class ExitGameKafkaProducerFactory extends GenericKafkaProducerFactory<ExitGameEvent> {

    public ExitGameKafkaProducerFactory(
            List<GenericKafkaProducerStrategy<? extends ExitGameEvent, ?, ?>> kafkaConsumerStrategies) {
        super(kafkaConsumerStrategies);
    }
}
