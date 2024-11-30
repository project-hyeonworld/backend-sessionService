package io.sessionservice.api.session.event;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public record GameInSessionEvent(int relationType, long userId, String userName) implements SessionEvent {

    public static GameInSessionEvent from(int relationType, Long userId, String userName) {
        return new GameInSessionEvent(relationType, userId, userName);
    }
}
