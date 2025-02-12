package io.sessionservice.api.session.event;

import io.sessionservice.common.event.GenericEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 4.
 */
@Component
public class SessionEventPublisher extends GenericEventPublisher<SessionEvent> {

  protected SessionEventPublisher(ApplicationEventPublisher publisher) {
    super(publisher);
  }

}
