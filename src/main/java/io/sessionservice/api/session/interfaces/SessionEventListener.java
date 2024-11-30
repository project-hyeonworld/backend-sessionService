package io.sessionservice.api.session.interfaces;

import com.toyproject.hyeonworld.api.session.event.SessionEvent;
import com.toyproject.hyeonworld.common.event.EventListener;

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
