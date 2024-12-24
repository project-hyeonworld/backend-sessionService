package io.sessionservice.api.session.event.kafka.producer.ingame.exitGame;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 20.
 */
public record ExitGameEventRecord(
        long partyId,
        String userName
) {

}