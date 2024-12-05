package io.sessionservice.common.event.kafka.producer;

import io.sessionservice.common.event.CustomEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class GenericKafkaProducerFactory<E extends CustomEvent> implements KafkaProducerFactory<E> {

    protected final Map<Class<? extends E>, GenericKafkaProducerStrategy<? extends E, ?, ?>> strategies;

    public GenericKafkaProducerFactory(List<GenericKafkaProducerStrategy<? extends E, ?, ?>> kafkaConsumerStrategies) {
        strategies = kafkaConsumerStrategies.stream()
                .collect(Collectors.toMap(GenericKafkaProducerStrategy::getEventClass, strategy -> strategy));
    }

    public GenericKafkaProducerStrategy<? extends E, ?, ?> getConsumer(Class<? extends E> eventClass) {
        return strategies.get(eventClass);
    }
}