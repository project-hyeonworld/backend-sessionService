package io.sessionservice.api.session.interfaces.handler.authentication;

import io.sessionservice.api.session.event.SessionEvent;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginKafkaSender;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginMessage;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.event.LoginEvent;
import io.sessionservice.common.event.GenericEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
@RequiredArgsConstructor
public class LoginSessionHandler extends GenericEventHandler<LoginEvent, SessionEvent> {

    private final LoginKafkaSender kafkaSender;

    @Override
    public Class<LoginEvent> getEventType() {
        return LoginEvent.class;
    }

    @Override
    public void handle(SessionEvent event) {
        kafkaSender.execute(LoginMessage.from((LoginEvent) event));
    }
}
