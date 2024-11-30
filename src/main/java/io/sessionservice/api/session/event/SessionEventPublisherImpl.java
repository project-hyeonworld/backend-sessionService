package io.sessionservice.api.session.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 4.
 */
@Component
@RequiredArgsConstructor
public class SessionEventPublisherImpl implements SessionEventPublisher{
  private final ApplicationEventPublisher applicationEventPublisher;

  @Override
  public void execute(SessionEvent event) {
    applicationEventPublisher.publishEvent(event);
  }
}
