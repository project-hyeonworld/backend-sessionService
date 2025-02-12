package io.sessionservice.api.session.interfaces.handler.authentication;

import io.sessionservice.api.session.client.party.PartyClient;
import io.sessionservice.api.session.client.user.UserClient;
import io.sessionservice.api.session.event.SessionEvent;
import io.sessionservice.api.session.event.kafka.producer.authentication.logout.LogoutMessage;
import io.sessionservice.api.session.event.kafka.producer.authentication.logout.event.LogoutEvent;
import io.sessionservice.api.session.event.kafka.producer.authentication.logout.LogoutKafkaSender;
import io.sessionservice.api.session.event.kafka.producer.authentication.logout.event.LogoutEventImpl;
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

    private final UserClient userClient;
    private final PartyClient partyClient;
    private final LogoutKafkaSender kafkaSender;


    @Override
    public Class<LogoutEvent> getEventType() {
        return LogoutEvent.class;
    }

    @Override
    public void handle(SessionEvent event) {
        LogoutEventImpl logoutEvent = (LogoutEventImpl) event;
        String userName = userClient.getUserNameById(event.userId());
        long partyId = partyClient.getByRelationType(logoutEvent.relationType());
        kafkaSender.execute(LogoutMessage.from(event.userId(), partyId, userName));
    }

}
