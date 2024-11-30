package io.sessionservice.api.session.controller.dto.req;

import com.toyproject.hyeonworld.api.session.application.dto.in.CreateLoginSessionCommand;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 4.
 */
public record SessionCreateRequest (
    String loginName
) implements SessionRequest
{
  public CreateLoginSessionCommand toCommand() {
    return new CreateLoginSessionCommand(loginName);
  }
}
