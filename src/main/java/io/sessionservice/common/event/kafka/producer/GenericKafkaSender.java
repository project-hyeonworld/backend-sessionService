package io.sessionservice.common.event.kafka.producer;

import io.sessionservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public abstract class GenericKafkaSender<E extends CustomEvent> implements KafkaSender<E> {

    protected GenericKafkaProducerManager<? extends E> manager;

    public GenericKafkaSender(GenericKafkaProducerManager<? extends E> kafkaProducerManager) {
        manager = kafkaProducerManager;
    }

    abstract public void execute(E event);
}
