package io.sessionservice.common.event.kafka.producer;

import io.sessionservice.api.session.event.kafka.producer.authentication.AuthenticationEvent;
import io.sessionservice.common.event.CustomEvent;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public abstract class GenericKafkaProducerStrategy<E extends CustomEvent, K, V> implements KafkaProducerStrategy<E, K, V> {

    protected final String TOPIC;
    protected KafkaProducer<K, V> kafkaProducer;

    protected GenericKafkaProducerStrategy(String topic) {
        TOPIC = topic;
    }

    public abstract Class<E> getEventClass();

    public void send(E event) {
        kafkaProducer.send(produce(event));
    }

    protected ProducerRecord<K, V> produce(E event) {
        return convertToRecord(event);
    }

    protected abstract ProducerRecord<K,V> convertToRecord(E event);
}
