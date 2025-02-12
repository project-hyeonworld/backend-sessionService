package io.sessionservice.api.session.client.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@FeignClient(name = "user-service", url = "${my.feign-client.user-service.address}"+":${my.feign-client.user-service.port}"+"${my.feign-client.user-service.end-point}")
public interface UserClient {

    @GetMapping("/authentication")
    UserRelationTypeInfo getAuthenticationByName(@RequestParam(name = "name") String userName);

    @GetMapping("/{userId}/in-game")
    UserNameRelationTypeInfo getUserNameRelationTypeById(@RequestParam(name = "userId") long userId);

    @PatchMapping("/{userId}/authentication/login")
    void patchLogin(@PathVariable(name ="userId") long userId);

    @PatchMapping("/{userId}/authentication/logout")
    UserRelationTypeInfo patchLogout(@PathVariable(name ="userId") long userId);

    @GetMapping("/relation-type")
    UserRelationTypeInfo getUserRelationTypeByName(@RequestParam(name = "name") String userName);

    @GetMapping("/{userId}/relation-type")
    int getRelationTypeById(@PathVariable(name = "userId") long userId);

    @GetMapping("/")
    boolean validateById(@PathVariable("id") long userId);

    @GetMapping("/{userId}/name")
    String getUserNameById(@PathVariable(name ="userId") long userId);
}