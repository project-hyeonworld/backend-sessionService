package io.sessionservice.api.session.event.kafka.producer.ingame.enterGame;

import io.sessionservice.api.session.event.kafka.producer.ingame.enterGame.event.EnterGameEvent;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import io.sessionservice.common.event.kafka.producer.GenericKafkaSender;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class EnterGameKafkaSender extends GenericKafkaSender<EnterGameEvent> {

    public EnterGameKafkaSender(
            GenericKafkaProducerManager<EnterGameEvent> kafkaProducerManager) {
        super(kafkaProducerManager);
    }

}
