package io.sessionservice.api.session.controller.dto.res;

import io.sessionservice.api.session.application.dto.out.PartyUserIdDto;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 4.
 */
public record SessionBasicResponse (
        Long partyId,
    long userId
) implements SessionResponse {

  public static SessionBasicResponse from(PartyUserIdDto partyUserIdDto) {
    return new SessionBasicResponse(partyUserIdDto.partyId(), partyUserIdDto.userId());
  }

  public static SessionBasicResponse from(long userId) {
    return new SessionBasicResponse(null, userId);
  }
}