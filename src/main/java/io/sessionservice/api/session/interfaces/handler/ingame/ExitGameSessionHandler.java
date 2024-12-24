package io.sessionservice.api.session.interfaces.handler.ingame;

import io.sessionservice.api.session.event.kafka.producer.ingame.IngameEvent;
import io.sessionservice.api.session.event.kafka.producer.ingame.exitGame.ExitGameKafkaSender;
import io.sessionservice.api.session.event.kafka.producer.ingame.exitGame.ExitGameMessage;
import io.sessionservice.api.session.event.kafka.producer.ingame.exitGame.event.ExitGameEvent;
import io.sessionservice.common.event.GenericEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
@RequiredArgsConstructor
public class ExitGameSessionHandler extends GenericEventHandler<ExitGameEvent, IngameEvent> {

    private final ExitGameKafkaSender kafkaSender;

    @Override
    public Class<ExitGameEvent> getEventType() {
        return ExitGameEvent.class;
    }

    @Override
    public void handle(IngameEvent event) {
        kafkaSender.execute(ExitGameMessage.from((ExitGameEvent)event));
    }


}
