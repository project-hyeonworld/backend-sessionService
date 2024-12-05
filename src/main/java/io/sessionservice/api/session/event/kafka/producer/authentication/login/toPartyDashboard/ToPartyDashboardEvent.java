package io.sessionservice.api.session.event.kafka.producer.authentication.login.toPartyDashboard;

import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public interface ToPartyDashboardEvent extends LoginEvent {
    long partyId();
}
