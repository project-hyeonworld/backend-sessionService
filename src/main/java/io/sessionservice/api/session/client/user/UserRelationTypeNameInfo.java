package io.sessionservice.api.session.client.user;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 11.
 */
public record UserRelationTypeNameInfo (
        long id,
        int relationType,
        String name
){

}
