package io.sessionservice.api.session.event.kafka.producer.authentication.login.event;

import io.sessionservice.api.session.event.kafka.producer.authentication.AuthenticationEvent;
import io.sessionservice.common.event.kafka.producer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public interface LoginEvent<T extends Message> extends AuthenticationEvent {

    static LoginEvent<?> from(long userId, long partyId, String userName) {
        return new LoginEventImpl(userId, partyId, userName);
    }
}