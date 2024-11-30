package io.sessionservice.api.session.event;


/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public record LogOutSessionEvent(int relationType, long userId, String userName) implements SessionEvent {

    public static LogOutSessionEvent from(int relationType, Long userId, String name) {
        return new LogOutSessionEvent(relationType, userId, name);
    }
}