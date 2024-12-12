package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.common.event.CustomEvent;
/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class LoginMessage implements LoginEvent {

    private final long userId;
    private final long partyId;
    private final String userName;

    public LoginMessage(long userId, long partyId, String userName) {
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

    public static LoginMessage from(long userId, long partyId, String userName) {
        return new LoginMessage(userId, partyId, userName);
    }

    LoginEventRecord toRecord() {
        return new LoginEventRecord(partyId, userName);
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return LoginEvent.class;
    }

    @Override
    public LoginEventRecord getRecordValue() {
        return toRecord();
    }
}
