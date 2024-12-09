package io.sessionservice.api.session.application;

import io.sessionservice.api.session.application.dto.in.CreateLoginSessionCommand;
import io.sessionservice.api.session.application.dto.in.SessionCommand;
import io.sessionservice.api.session.application.dto.out.PartyUserIdDto;
import io.sessionservice.api.session.client.party.PartyClient;
import io.sessionservice.api.session.client.user.UserClient;
import io.sessionservice.api.session.client.user.UserRelationTypeInfo;
import io.sessionservice.api.session.event.SessionEvent;
import io.sessionservice.api.session.event.SessionEventPublisher;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEventImpl;
import io.sessionservice.common.annotation.Facade;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 4.
 */
@Facade
@RequiredArgsConstructor
public class SessionFacade {

  private final UserClient userClient;
  private final PartyClient partyClient;
  private final SessionEventPublisher eventPublisher;

  public PartyUserIdDto createLoginSession(CreateLoginSessionCommand command) {
    UserRelationTypeInfo userInfo = userClient.getAuthenticationByName(command.userName());
    Long availablePartyId = partyClient.getByRelationType(userInfo.relationType());
    if (availablePartyId != null) {
      CompletableFuture.runAsync(()->eventPublisher.execute(LoginEventImpl.from(userInfo.id(), availablePartyId, command.userName())));
    }
    return PartyUserIdDto.from(availablePartyId, userInfo.id());
  }

  public long deleteLoginSession(SessionCommand command) {
    boolean existingUserId = userClient.validateById(command.userId());
    //UserInfo userInfo = userService.confirmLogOut(command.userId());
    //eventPublisher.execute(LogOutSessionEvent.from(userInfo.getRelationType().ordinal(), userInfo.getId(), userInfo.getName()));
    return command.userId();
  }

  public long enterGame(SessionCommand command) {
    boolean existingUserId = userClient.validateById(command.userId());
    //UserInfo userInfo = userService.confirmEnterGame(command.userId());
    //eventPublisher.execute(GameInSessionEvent.from(userInfo.getRelationType().ordinal(), userInfo.getId(), userInfo.getName()));
    return command.userId();
  }

  public long exitGame(SessionCommand command) {
    boolean existingUserId = userClient.validateById(command.userId());
    //UserInfo userInfo = userService.confirmExitGame(command.userId());
    //eventPublisher.execute(GameOutSessionEvent.from(userInfo.getRelationType().ordinal(), userInfo.getId(), userInfo.getName()));
    return command.userId();
  }

  private void publishEvent(SessionEvent event) {

  }
}
