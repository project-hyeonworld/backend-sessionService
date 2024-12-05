package io.sessionservice.api.session.interfaces.handler.authentication;

import io.sessionservice.api.session.event.SessionEvent;
import io.sessionservice.api.session.event.kafka.producer.authentication.logout.LogoutKafkaSender;
import io.sessionservice.api.session.event.kafka.producer.authentication.logout.LogoutEvent;
import io.sessionservice.common.event.GenericEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
@RequiredArgsConstructor
public class LogoutSessionHandler extends GenericEventHandler<LogoutEvent, SessionEvent> {

    private final LogoutKafkaSender kafkaSender;

    @Override
    public Class<LogoutEvent> getEventType() {
        return LogoutEvent.class;
    }

    @Override
    public void handle(SessionEvent event) {
        kafkaSender.execute((LogoutEvent)event);
    }
}
