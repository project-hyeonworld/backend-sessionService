package io.sessionservice.common.event.kafka.producer.destination;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 6.
 */
public interface Destination<K> {
    K getRecordValue();
}
