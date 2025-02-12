package io.sessionservice.api.session.event.kafka.producer.ingame.exitGame;

import io.sessionservice.api.session.event.kafka.producer.ingame.enterGame.event.EnterGameEvent;
import io.sessionservice.api.session.event.kafka.producer.ingame.exitGame.event.ExitGameEvent;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducers;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class ExitGameKafkaProducerManager extends GenericKafkaProducerManager<ExitGameEvent> {

    private final GenericKafkaProducer<ExitGameEvent, ?, ?> producer;

    public ExitGameKafkaProducerManager(
            GenericKafkaProducer<ExitGameEvent, ?, ?> genericKafkaProducer) {
        producer = genericKafkaProducer;
    }

    @Override
    public void send(ExitGameEvent event) {
        producer.send(event);
    }

}
