package io.sessionservice.api.session.event.kafka.producer.ingame.exitGame;

import io.sessionservice.api.session.event.kafka.producer.ingame.exitGame.event.ExitGameEvent;
import io.sessionservice.api.session.event.kafka.producer.ingame.exitGame.event.ExitGameEventImpl;
import io.sessionservice.common.event.CustomEvent;
import io.sessionservice.common.event.kafka.producer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 20.
 */
public class ExitGameMessage implements ExitGameEvent, Message {

    private final long userId;
    private final long partyId;
    private final String userName;

    private ExitGameMessage(long userId, long partyId, String userName) {
        this.userId = userId;
        this.partyId = partyId;
        this.userName = userName;
    }

    public static ExitGameEvent from(ExitGameEvent event) {
        ExitGameEventImpl impl = (ExitGameEventImpl) event;
        return new ExitGameMessage(impl.userId(), impl.partyId(), impl.userName());
    }

    @Override
    public long userId() {
        return userId;
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return ExitGameEvent.class;
    }

    @Override
    public ExitGameEventRecord getRecordValue() {
        return new ExitGameEventRecord(partyId, userName);
    }
}
