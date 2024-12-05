package io.sessionservice.api.session.event.kafka.producer.authentication.login;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class LoginEventImpl implements LoginEvent {

    private final long userId;
    private final long partyId;
    private final String userName;

    private LoginEventImpl(long userId, long partyId, String userName) {
        this.userId = userId;
        this.partyId = partyId;
        this.userName = userName;
    }

    @Override
    public long userId() {
        return userId;
    }

    public static LoginEventImpl from(long userId, long partyId, String userName) {
        return new LoginEventImpl(userId, partyId, userName);
    }
}
