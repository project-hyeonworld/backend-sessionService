package io.sessionservice.api.session.event.kafka.producer.ingame.exitGame.event;

import io.sessionservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 20.
 */
public class ExitGameEventImpl implements ExitGameEvent {

    private final long userId;
    private final long partyId;
    private final String userName;

    ExitGameEventImpl(long userId, long partyId, String userName) {
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
        return ExitGameEvent.class;
    }
}
