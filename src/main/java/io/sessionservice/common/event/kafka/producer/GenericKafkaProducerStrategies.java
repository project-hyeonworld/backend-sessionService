package io.sessionservice.common.event.kafka.producer;

import io.sessionservice.common.event.CustomEvent;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 6.
 */
public abstract class GenericKafkaProducerStrategies<E extends CustomEvent> implements KafkaProducerStrategy {

    protected List<GenericKafkaProducerStrategy<? extends E, ?, ?>> strategies;
    protected final Executor executor;

    public GenericKafkaProducerStrategies(List<GenericKafkaProducerStrategy<? extends E, ?, ?>> kafkaProducerStrategies) {
        strategies = kafkaProducerStrategies;
        executor = Executors.newFixedThreadPool(strategies.size());
    }

    public int size() {
        return strategies.size();
    }
}
