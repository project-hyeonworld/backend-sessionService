package io.sessionservice.api.session.event.kafka.producer.authentication.logout;

import io.sessionservice.api.session.event.kafka.producer.authentication.logout.event.LogoutEvent;
import io.sessionservice.common.event.CustomEvent;
import io.sessionservice.common.event.kafka.producer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 13.
 */
public class LogoutMessage implements LogoutEvent, Message {

    private final long userId;
    private final long partyId;
    private final String userName;

    private LogoutMessage(long userId, long partyId, String userName) {
        this.userId = userId;
        this.partyId = partyId;
        this.userName = userName;
    }

    public static LogoutMessage from(long userId, long partyId, String userName) {
        return new LogoutMessage(userId, partyId, userName);
    }

    @Override
    public long userId() {
        return userId;
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return LogoutEvent.class;
    }

    @Override
    public LogoutEventRecord getRecordValue() {
        return toRecord();
    }

    private LogoutEventRecord toRecord() {
        return new LogoutEventRecord(partyId, userName);
    }


}
