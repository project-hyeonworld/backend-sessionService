package io.sessionservice.api.session.event.kafka.producer.authentication.login.toPartyDashboard;

import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEvent;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEventImpl;
import io.sessionservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class ToPartyDashboardEventImpl implements ToPartyDashboardEvent {

    private long partyId;
    private long userId;

    private ToPartyDashboardEventImpl(long partyId, long userId) {
        this.partyId = partyId;
        this.userId = userId;
    }

    @Override
    public long partyId() {
        return partyId;
    }

    @Override
    public long userId() {
        return userId;
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return ToPartyDashboardEvent.class;
    }

    public static ToPartyDashboardEventImpl from(LoginEvent event) {
        LoginEventImpl impl = (LoginEventImpl) event;
        return new ToPartyDashboardEventImpl(impl.partyId() , impl.userId());
    }
}
