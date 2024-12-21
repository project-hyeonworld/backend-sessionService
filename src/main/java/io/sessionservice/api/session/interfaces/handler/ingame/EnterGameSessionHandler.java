package io.sessionservice.api.session.interfaces.handler.ingame;

import io.sessionservice.api.session.event.SessionEvent;
import io.sessionservice.api.session.event.kafka.producer.ingame.enterGame.EnterGameKafkaSender;
import io.sessionservice.api.session.event.kafka.producer.ingame.enterGame.EnterGameMessage;
import io.sessionservice.api.session.event.kafka.producer.ingame.enterGame.event.EnterGameEvent;
import io.sessionservice.common.event.GenericEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
@RequiredArgsConstructor
public class EnterGameSessionHandler extends GenericEventHandler<EnterGameEvent, SessionEvent> {

    private final EnterGameKafkaSender kafkaSender;

    @Override
    public Class<EnterGameEvent> getEventType() {
        return EnterGameEvent.class;
    }

    @Override
    public void handle(SessionEvent event) {
        kafkaSender.execute(EnterGameMessage.from((EnterGameEvent) event));
    }
}
