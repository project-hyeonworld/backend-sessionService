package io.sessionservice.api.session.event.kafka.producer.ingame.enterGame;

import io.sessionservice.api.session.event.kafka.producer.ingame.enterGame.event.EnterGameEvent;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerFactory;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class EnterGameKafkaProducerFactory extends GenericKafkaProducerFactory<EnterGameEvent> {

    public EnterGameKafkaProducerFactory(
            List<GenericKafkaProducer<? extends EnterGameEvent, ?, ?>> kafkaConsumerStrategies) {
        super(kafkaConsumerStrategies);
    }
}
