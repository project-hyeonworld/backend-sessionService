package io.sessionservice.common.event.kafka.producer;

import io.sessionservice.common.event.CustomEvent;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 6.
 */
public abstract class GenericKafkaProducers<E extends CustomEvent> implements KafkaProducerStrategy {

    protected List<GenericKafkaProducer<? extends E, ?, ?>> strategies;
    protected final Executor executor;

    public GenericKafkaProducers(List<GenericKafkaProducer<? extends E, ?, ?>> kafkaProducerStrategies) {
        strategies = kafkaProducerStrategies;
        executor = Executors.newFixedThreadPool(strategies.size());
    }

    public int size() {
        return strategies.size();
    }

    public abstract void send(E event);
}
