package io.sessionservice.common.event.kafka.producer;

import io.sessionservice.common.event.CustomEvent;
import io.sessionservice.common.event.EventPublisher;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 1.
 */
public interface KafkaSender<E extends CustomEvent> extends EventPublisher<E> {
}
