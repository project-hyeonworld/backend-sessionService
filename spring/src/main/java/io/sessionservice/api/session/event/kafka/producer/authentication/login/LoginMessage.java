package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.api.session.event.kafka.producer.authentication.login.event.LoginEvent;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.event.LoginEventImpl;
import io.sessionservice.common.event.CustomEvent;
import io.sessionservice.common.event.kafka.producer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class LoginMessage implements LoginEvent, Message {

    private final long userId;
    private final long partyId;
    private final String userName;

    private LoginMessage(long userId, long partyId, String userName) {
        this.userId = userId;
        this.partyId = partyId;
        this.userName = userName;
    }

    public static LoginMessage from(LoginEvent loginEvent) {
        LoginEventImpl impl = (LoginEventImpl) loginEvent;
        return new LoginMessage(impl.userId(), impl.partyId(), impl.userName());
    }

    @Override
    public long userId() {
        return userId;
    }

    public long partyId() {
        return partyId;
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return LoginEvent.class;
    }

    @Override
    public LoginEventRecord getRecordValue() {
        return toRecord();
    }

    private LoginEventRecord toRecord() {
        return new LoginEventRecord(partyId, userName);
    }
}
