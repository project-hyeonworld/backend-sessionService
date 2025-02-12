package io.sessionservice.api.session.event.kafka.producer.authentication.login.event;

import io.sessionservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 13.
 */
public class LoginEventImpl implements LoginEvent {

    private final long userId;
    private final long partyId;
    private final String userName;

    LoginEventImpl(long userId, long partyId, String userName) {
        this.userId = userId;
        this.partyId = partyId;
        this.userName = userName;
    }

    @Override
    public long userId() {
        return userId;
    }

    public long partyId() {
        return partyId;
    }

    public String userName() {
        return userName;
    }


    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return LoginEvent.class;
    }
}
