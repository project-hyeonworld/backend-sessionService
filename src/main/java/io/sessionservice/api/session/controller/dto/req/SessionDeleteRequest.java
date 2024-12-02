package io.sessionservice.api.session.controller.dto.req;

import io.userservice.api.session.application.dto.in.SessionCommand;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 4.
 */
public record SessionDeleteRequest(
    long userId
) implements SessionRequest {
  public SessionCommand toCommand() {
    return new SessionCommand(userId);
  }
}