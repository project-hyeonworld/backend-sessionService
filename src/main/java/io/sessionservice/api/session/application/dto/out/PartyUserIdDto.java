package io.sessionservice.api.session.application.dto.out;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 18.
 */
public record PartyUserIdDto (
        Long partyId,
        long userId
){

    public static PartyUserIdDto from(Long partyId, long userId) {
        return new PartyUserIdDto(partyId, userId);
    }
}
