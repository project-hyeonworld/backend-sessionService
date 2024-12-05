package io.sessionservice.api.session.event.kafka.producer.ingame.exitGame;

import io.sessionservice.api.session.event.kafka.producer.ingame.enterGame.EnterGameEvent;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerStrategy;
import io.sessionservice.common.event.kafka.producer.GenericKafkaSender;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class ExitGameKafkaSender extends GenericKafkaSender<ExitGameEvent> {

    public ExitGameKafkaSender(
            GenericKafkaProducerManager<ExitGameEvent> kafkaProducerManager) {
        super(kafkaProducerManager);
    }

    @Override
    public void execute(ExitGameEvent event) {
        GenericKafkaProducerStrategy producer = manager.getProducer(event.getClass());
        producer.send(event);
    }
}
