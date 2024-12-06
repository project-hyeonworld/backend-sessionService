package io.sessionservice.common.event.kafka.producer;

import io.sessionservice.common.event.CustomEvent;
/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public abstract class GenericKafkaProducerManager<E extends CustomEvent> implements KafkaProducerManager<E> {

    protected GenericKafkaProducers<E> strategies;

    public GenericKafkaProducerManager(GenericKafkaProducers<E> genericKafkaProducers) {
        strategies = genericKafkaProducers;
    }

    public abstract void send(E event);
}