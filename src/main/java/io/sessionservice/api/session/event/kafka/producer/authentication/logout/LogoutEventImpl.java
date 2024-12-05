package io.sessionservice.api.session.event.kafka.producer.authentication.logout;

import io.sessionservice.api.session.event.SessionEvent;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class LogoutEventImpl implements LogoutEvent {

    private final long userId;

    @Override
    public Class<? extends SessionEvent> getEventType() {
        return LogoutEvent.class;
    }

    private LogoutEventImpl(long userId) {
        this.userId = userId;
    }

    @Override
    public long userId() {
        return userId;
    }

    public static LogoutEventImpl from(long userId) {
        return new LogoutEventImpl(userId);
    }
}
