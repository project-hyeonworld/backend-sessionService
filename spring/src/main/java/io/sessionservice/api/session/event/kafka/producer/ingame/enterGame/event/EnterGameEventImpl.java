package io.sessionservice.api.session.event.kafka.producer.ingame.enterGame.event;

import io.sessionservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 18.
 */
public class EnterGameEventImpl implements EnterGameEvent {

    private final long userId;
    private final long partyId;
    private final String userName;

    EnterGameEventImpl(long userId, long partyId, String userName) {
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

    public String userName(){
        return userName;
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return EnterGameEvent.class;
    }
}
