package io.sessionservice.api.session.event;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public record LogInSessionEvent(long partyId, long userId, String userName) implements SessionEvent {

    public static LogInSessionEvent from(long partyId, long userId, String userName) {
        return new LogInSessionEvent(partyId, userId, userName);
    }
}