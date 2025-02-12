package io.sessionservice.api.session.event.kafka.producer.authentication.logout.event;

import io.sessionservice.api.session.event.kafka.producer.authentication.AuthenticationEvent;
import io.sessionservice.common.event.kafka.producer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public interface LogoutEvent<T extends Message> extends AuthenticationEvent {

    static LogoutEvent<?> from(long userId, int relationType) {
        return new LogoutEventImpl(userId, relationType);
    }
}