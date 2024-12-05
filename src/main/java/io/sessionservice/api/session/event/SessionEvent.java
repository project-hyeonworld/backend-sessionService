package io.sessionservice.api.session.event;

import io.sessionservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 4.
 */
public interface SessionEvent extends CustomEvent {
    long userId();
}
