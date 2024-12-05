package io.sessionservice.api.session.event.kafka.producer.authentication.login;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public record LoginEventRecord(
        long userId,
        long partyId,
        String userName
)  {
}
