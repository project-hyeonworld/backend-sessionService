package io.sessionservice.api.session.event.kafka.producer.authentication.logout;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 13.
 */
public record LogoutEventRecord(
        long partyId,
        String userName
)  {
}
