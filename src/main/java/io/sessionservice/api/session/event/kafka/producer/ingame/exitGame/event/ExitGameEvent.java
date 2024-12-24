package io.sessionservice.api.session.event.kafka.producer.ingame.exitGame.event;

import io.sessionservice.api.session.event.kafka.producer.ingame.IngameEvent;
import io.sessionservice.common.event.kafka.producer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public interface ExitGameEvent<T extends Message> extends IngameEvent {

    static ExitGameEvent<?> from(long userId, long partyId, String userName) {
        return new ExitGameEventImpl(userId, partyId, userName);
    }
}
