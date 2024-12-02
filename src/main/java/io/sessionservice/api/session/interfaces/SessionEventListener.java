package io.sessionservice.api.session.interfaces;

import io.userservice.api.session.event.SessionEvent;
import io.userservice.common.event.EventListener;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 4.
 */
public interface SessionEventListener extends EventListener<SessionEvent> {
  void handleLoginSessionEvent(SessionEvent sessionEvent);
  void handleGameInSessionEvent(SessionEvent sessionEvent);
  void handleGameOutSessionEvent(SessionEvent sessionEvent);
  void handleLogoutSessionEvent(SessionEvent sessionEvent);
}
