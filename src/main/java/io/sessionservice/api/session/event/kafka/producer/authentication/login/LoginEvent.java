package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.api.session.event.kafka.producer.authentication.AuthenticationEvent;
import io.sessionservice.common.event.kafka.producer.destination.Destination;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public interface LoginEvent<T extends Destination> extends AuthenticationEvent, Destination {
}