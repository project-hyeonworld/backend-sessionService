package io.sessionservice.common.event.kafka.producer;

import io.sessionservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class GenericKafkaProducerManager<E extends CustomEvent> implements KafkaProducerManager<E> {

    protected GenericKafkaProducerFactory<E> factory;

    public GenericKafkaProducerManager(GenericKafkaProducerFactory<E> genericKafkaProducerFactory) {
        factory = genericKafkaProducerFactory;
    }

    public GenericKafkaProducerStrategy<? extends E, ?, ?> getProducer(Class<? extends CustomEvent> event) {
        return factory.getProducer(event);
    }

}