package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.api.session.event.SessionEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class LoginEventImpl implements LoginEvent {

    private final long userId;
    private final long partyId;
    private final String userName;

    @Override
    public Class<? extends SessionEvent> getEventClass() {
        return LoginEvent.class;
    }

    public LoginEventImpl(long userId, long partyId, String userName) {
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

    public static LoginEventImpl from(long userId, long partyId, String userName) {
        return new LoginEventImpl(userId, partyId, userName);
    }

    LoginEventRecord toRecord() {
        return new LoginEventRecord(userId, partyId, userName);
    }
}
