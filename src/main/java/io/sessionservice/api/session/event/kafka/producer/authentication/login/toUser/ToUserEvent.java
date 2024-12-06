package io.sessionservice.api.session.event.kafka.producer.authentication.login.toUser;

import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEvent;
import io.sessionservice.api.session.event.kafka.producer.destination.ToUser;
import io.sessionservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 6.
 */
public class ToUserEvent implements LoginEvent<ToUser> {

    private final long userId;

    private ToUserEvent(long userId) {
        this.userId = userId;
    }

    public static ToUserEvent from(LoginEvent event) {
        return new ToUserEvent(event.userId());
    }

    @Override
    public Long getRecordValue() {
        return userId;
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return this.getClass();
    }

    @Override
    public long userId() {
        return userId;
    }
}
