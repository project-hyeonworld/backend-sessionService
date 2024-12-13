package io.sessionservice.api.session.event.kafka.producer.authentication.logout.event;

import io.sessionservice.api.session.event.SessionEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class LogoutEventImpl implements LogoutEvent {

    private final long userId;
    private final int relationType;

    @Override
    public Class<? extends SessionEvent> getEventClass() {
        return LogoutEvent.class;
    }

    LogoutEventImpl(long userId, int relationType) {
        this.userId = userId;
        this.relationType = relationType;
    }

    @Override
    public long userId() {
        return userId;
    }

    public int relationType() {
        return relationType;
    }

    public static LogoutEventImpl from(long userId, int relationType) {
        return new LogoutEventImpl(userId, relationType);
    }
}
