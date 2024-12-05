package io.sessionservice.api.session.controller.dto.req;

import io.sessionservice.api.session.application.dto.in.CreateLoginSessionCommand;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 4.
 */
public record AuthenticationCreateRequest(
    String userName
) implements SessionRequest
{
  public CreateLoginSessionCommand toCommand() {
    return new CreateLoginSessionCommand(userName);
  }
}
