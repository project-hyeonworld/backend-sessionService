package io.sessionservice.api.session.event.kafka.producer.authentication.login.toPartyDashboard;

import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEventImpl;
import io.sessionservice.api.session.event.kafka.producer.destination.ToPartyDashboard;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEvent;
import io.sessionservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class ToPartyDashboardEvent implements LoginEvent<ToPartyDashboard> {

    private final long partyId;
    private final long userId;

    private ToPartyDashboardEvent(long partyId, long userId) {
        this.partyId = partyId;
        this.userId = userId;
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return this.getClass();
    }

    public static ToPartyDashboardEvent from(LoginEvent event) {
        LoginEventImpl impl = (LoginEventImpl) event;
        return new ToPartyDashboardEvent(impl.partyId() , impl.userId());
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
