package io.sessionservice.api.session.application;

import com.toyproject.hyeonworld.api.party.domain.PartyService;
import io.userservice.api.session.application.dto.in.CreateLoginSessionCommand;
import io.userservice.api.session.application.dto.in.SessionCommand;
import io.userservice.api.session.application.dto.out.PartyUserIdDto;
import io.userservice.api.session.event.GameInSessionEvent;
import io.userservice.api.session.event.GameOutSessionEvent;
import io.userservice.api.session.event.LogInSessionEvent;
import io.userservice.api.session.event.LogOutSessionEvent;
import io.userservice.api.session.event.SessionEventPublisher;
import com.toyproject.hyeonworld.api.user.domain.UserService;
import com.toyproject.hyeonworld.api.user.domain.dto.out.UserInfo;
import io.userservice.common.annotation.Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 4.
 */
@Facade
@RequiredArgsConstructor
public class SessionUserFacade {

  private final UserService userService;
  private final PartyService partyService;
  private final SessionEventPublisher eventPublisher;

  @Transactional
  public PartyUserIdDto createLoginSession(CreateLoginSessionCommand command) {
    UserInfo userInfo = userService.getUserByName(command.userName());
    Long partyId = partyService.findByRelationType(userInfo.getRelationType().ordinal());
    if (partyId == null) {
      return PartyUserIdDto.from(null, userInfo.getId());
    }
    eventPublisher.execute(LogInSessionEvent.from(partyId, userInfo.getId(), userInfo.getName()));
    return PartyUserIdDto.from(partyId, userInfo.getId());
  }

  @Transactional
  public long deleteLoginSession(SessionCommand command) {
    UserInfo userInfo = userService.confirmLogOut(command.userId());
    eventPublisher.execute(LogOutSessionEvent.from(userInfo.getRelationType().ordinal(), userInfo.getId(), userInfo.getName()));
    return command.userId();
  }

  @Transactional
  public long enterGame(SessionCommand command) {
    UserInfo userInfo = userService.confirmEnterGame(command.userId());
    eventPublisher.execute(GameInSessionEvent.from(userInfo.getRelationType().ordinal(), userInfo.getId(), userInfo.getName()));
    return command.userId();
  }

  @Transactional
  public long exitGame(SessionCommand command) {
    UserInfo userInfo = userService.confirmExitGame(command.userId());
    eventPublisher.execute(GameOutSessionEvent.from(userInfo.getRelationType().ordinal(), userInfo.getId(), userInfo.getName()));
    return command.userId();
  }
}
