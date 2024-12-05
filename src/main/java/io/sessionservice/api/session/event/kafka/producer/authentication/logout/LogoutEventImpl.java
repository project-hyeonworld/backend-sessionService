package io.sessionservice.api.session.event.kafka.producer.authentication.logout;

import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class LogoutEventImpl implements LoginEvent {

    private final long userId;

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
