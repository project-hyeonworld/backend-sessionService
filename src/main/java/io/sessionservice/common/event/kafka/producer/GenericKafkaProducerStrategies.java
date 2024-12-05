package io.sessionservice.common.event.kafka.producer;

import io.sessionservice.common.event.CustomEvent;
import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 6.
 */
public abstract class GenericKafkaProducerStrategies<E extends CustomEvent> implements KafkaProducerStrategy {

    protected List<GenericKafkaProducerStrategy<? extends E, ?, ?>> strategies;

    public GenericKafkaProducerStrategies(List<GenericKafkaProducerStrategy<? extends E, ?, ?>> kafkaProducerStrategies) {
        strategies = kafkaProducerStrategies;
    }
}
