package io.sessionservice.api.session.event.kafka.producer.authentication.login.toUser;

import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEvent;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEventImpl;
import io.sessionservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class ToUserEventImpl implements ToUserEvent {

    private long userId;

    public ToUserEventImpl(long userId) {
        this.userId = userId;
    }

    public static ToUserEventImpl from(LoginEvent event) {
        return new ToUserEventImpl(event.userId());
    }

    @Override
    public long userId() {
        return userId;
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return ToUserEvent.class;
    }
}
