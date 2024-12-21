package io.sessionservice.api.session.event.kafka.producer.ingame.enterGame.event;

import io.sessionservice.api.session.event.kafka.producer.ingame.IngameEvent;
import io.sessionservice.common.event.kafka.producer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public interface EnterGameEvent<T extends Message> extends IngameEvent {

    static EnterGameEvent<?> from(long userId, long partyId, String userName) {
        return new EnterGameEventImpl(userId, partyId, userName);
    }

}
