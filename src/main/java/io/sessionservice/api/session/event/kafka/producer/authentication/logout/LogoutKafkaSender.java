package io.sessionservice.api.session.event.kafka.producer.authentication.logout;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerStrategy;
import io.sessionservice.common.event.kafka.producer.GenericKafkaSender;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class LogoutKafkaSender extends GenericKafkaSender<LogoutEvent> {

    public LogoutKafkaSender(
            GenericKafkaProducerManager<LogoutEvent> kafkaProducerManager) {
        super(kafkaProducerManager);
    }


    @Override
    public void execute(LogoutEvent event) {
        GenericKafkaProducerStrategy producer = manager.getProducer(event.getClass());
        producer.send(event);
    }
}
