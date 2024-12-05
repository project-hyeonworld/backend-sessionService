package io.sessionservice.api.session.event.kafka.producer.ingame.enterGame;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerFactory;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class EnterGameKafkaProducerManager extends GenericKafkaProducerManager<EnterGameEvent> {

    public EnterGameKafkaProducerManager(
            GenericKafkaProducerFactory<EnterGameEvent> genericKafkaConsumerFactory) {
        super(genericKafkaConsumerFactory);
    }
}
