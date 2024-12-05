package io.sessionservice.api.session.controller.dto.req;

import io.sessionservice.api.session.application.dto.in.SessionCommand;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 4.
 */
public record SessionGameRequest (long userId) implements SessionRequest {
  public SessionCommand toCommand() {
    return new SessionCommand(userId);
  }
}
