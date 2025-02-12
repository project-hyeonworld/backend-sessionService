package io.sessionservice.api.session.event;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public record GameOutSessionEvent(int relationType, long userId, String userName) implements SessionEvent {

    public static GameOutSessionEvent from(int relationType, Long userId, String userName) {
        return new GameOutSessionEvent(relationType, userId, userName);
    }

    @Override
    public Class<? extends SessionEvent> getEventClass() {
        return GameOutSessionEvent.class;
    }
}