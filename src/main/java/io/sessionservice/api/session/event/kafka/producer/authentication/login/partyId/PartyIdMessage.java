package io.sessionservice.api.session.event.kafka.producer.authentication.login.partyId;

import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginMessage;
import io.sessionservice.api.session.event.kafka.producer.message.PartyId;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEvent;
import io.sessionservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class PartyIdMessage implements LoginEvent<PartyId> {

    private final long partyId;
    private final long userId;

    private PartyIdMessage(long partyId, long userId) {
        this.partyId = partyId;
        this.userId = userId;
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return this.getClass();
    }

    public static PartyIdMessage from(LoginEvent event) {
        LoginMessage impl = (LoginMessage) event;
        return new PartyIdMessage(impl.partyId() , impl.userId());
    }

    @Override
    public long userId() {
        return userId;
    }

    @Override
    public Long getRecordValue() {
        return partyId;
    }


}
