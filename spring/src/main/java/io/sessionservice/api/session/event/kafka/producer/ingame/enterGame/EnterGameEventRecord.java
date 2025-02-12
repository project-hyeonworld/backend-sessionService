package io.sessionservice.api.session.event.kafka.producer.ingame.enterGame;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 18.
 */
public record EnterGameEventRecord(
        long partyId,
        String userName
) {

}
