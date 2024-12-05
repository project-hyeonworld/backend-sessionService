package io.sessionservice.api.session.event.kafka.producer.ingame.exitGame;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerFactory;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class ExitGameKafkaProducerManager extends GenericKafkaProducerManager<ExitGameEvent> {

    public ExitGameKafkaProducerManager(
            GenericKafkaProducerFactory<ExitGameEvent> genericKafkaConsumerFactory) {
        super(genericKafkaConsumerFactory);
    }
}
