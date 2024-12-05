package io.sessionservice.api.session.interfaces;

import static org.springframework.transaction.event.TransactionPhase.BEFORE_COMMIT;

import io.sessionservice.api.session.event.SessionEvent;
import io.sessionservice.common.event.GenericEventHandler;
import io.sessionservice.common.event.GenericEventListener;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 4.
 */
@Component
public class SessionEventListener extends GenericEventListener<SessionEvent> {


    public SessionEventListener(
            List<GenericEventHandler<? extends SessionEvent, SessionEvent>> handlers) {
        super(handlers);
    }

    @Override
    @TransactionalEventListener(phase = BEFORE_COMMIT)
    public void handleEvent(SessionEvent event) {
        handlers.get(event.getEventType()).handle(event);
    }
}
