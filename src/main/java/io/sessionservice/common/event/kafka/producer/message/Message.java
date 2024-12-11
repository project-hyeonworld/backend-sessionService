package io.sessionservice.common.event.kafka.producer.message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 6.
 */
public interface Message {
    Object getRecordValue();
}
