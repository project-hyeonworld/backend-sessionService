package io.sessionservice.api.session.interfaces;

import static org.springframework.transaction.event.TransactionPhase.BEFORE_COMMIT;

import io.userservice.api.session.event.GameInSessionEvent;
import io.userservice.api.session.event.GameOutSessionEvent;
import io.userservice.api.session.event.LogInSessionEvent;
import io.userservice.api.session.event.LogOutSessionEvent;
import io.userservice.api.session.event.SessionEvent;
import com.toyproject.hyeonworld.api.sse.application.SsePartyFacade;
import com.toyproject.hyeonworld.api.user.domain.UserService;
import java.util.Map;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 4.
 */
@Component
@RequiredArgsConstructor
public class SessionEventListenerImpl implements SessionEventListener {
    private final UserService userService;
    private final SsePartyFacade ssePartyFacade;

    private final Map<Class<? extends SessionEvent>, Consumer<SessionEvent>>
            eventHandlers = Map.of(
            LogInSessionEvent.class, this::handleLoginSessionEvent,
            GameInSessionEvent.class, this::handleGameInSessionEvent,
            GameOutSessionEvent.class, this::handleGameOutSessionEvent,
            LogOutSessionEvent.class, this::handleLogoutSessionEvent
    );

    @Override
    @TransactionalEventListener(phase = BEFORE_COMMIT)
    public void handleEvent(SessionEvent event) {
        Consumer<SessionEvent> a = eventHandlers.getOrDefault(event.getClass(), this::handleUnknownEvent);
        a.accept(event);
    }

    @Override
    public void handleLoginSessionEvent(SessionEvent event) {
        LogInSessionEvent logInSessionEvent = (LogInSessionEvent) event;
        userService.confirmLogin(logInSessionEvent.userId());
        if (logInSessionEvent.partyId() != -1) {
            ssePartyFacade.logIn(logInSessionEvent.partyId(),
                    logInSessionEvent.userName());
        }
    }

    @Override
    public void handleGameOutSessionEvent(SessionEvent event) {
        GameOutSessionEvent gameOutSessionEvent = (GameOutSessionEvent) event;
        ssePartyFacade.gameOut(gameOutSessionEvent.relationType(), gameOutSessionEvent.userId(),
                gameOutSessionEvent.userName());
    }

    @Override
    public void handleGameInSessionEvent(SessionEvent event) {
        GameInSessionEvent gameInSessionEvent = (GameInSessionEvent) event;
        ssePartyFacade.gameIn(gameInSessionEvent.relationType(),
                gameInSessionEvent.userName());
    }

    @Override
    public void handleLogoutSessionEvent(SessionEvent event) {
        LogOutSessionEvent logOutSessionEvent = (LogOutSessionEvent) event;
        ssePartyFacade.logOut(logOutSessionEvent.relationType(), logOutSessionEvent.userId(),
                logOutSessionEvent.userName());
    }

    private void handleUnknownEvent(SessionEvent event) {
        throw new IllegalArgumentException("Unexpected event type: " + event.getClass());
    }

}
