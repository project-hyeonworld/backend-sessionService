package io.sessionservice.api.session.event.kafka.producer.authentication.login.userName;

import io.sessionservice.api.session.event.kafka.producer.message.UserName;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEvent;
import io.sessionservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 6.
 */
public class UserNameMessage implements LoginEvent<UserName> {

    private final long userId;

    private UserNameMessage(long userId) {
        this.userId = userId;
    }

    public static UserNameMessage from(LoginEvent event) {
        return new UserNameMessage(event.userId());
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
