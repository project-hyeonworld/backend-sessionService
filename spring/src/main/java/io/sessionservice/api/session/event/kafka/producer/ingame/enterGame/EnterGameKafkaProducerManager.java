package io.sessionservice.api.session.event.kafka.producer.ingame.enterGame;


import io.sessionservice.api.session.event.kafka.producer.ingame.enterGame.event.EnterGameEvent;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducers;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class EnterGameKafkaProducerManager extends GenericKafkaProducerManager<EnterGameEvent> {

    private final GenericKafkaProducer<EnterGameEvent, ?, ?> producer;

    public EnterGameKafkaProducerManager(
            GenericKafkaProducer<EnterGameEvent, ?, ?> enterGameKafkaProducer) {
        producer = enterGameKafkaProducer;
    }

    @Override
    public void send(EnterGameEvent event) {
        producer.send(event);
    }
}
