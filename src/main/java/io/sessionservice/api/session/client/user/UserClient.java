package io.sessionservice.api.session.client.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@FeignClient(name = "user-service", url = "${my.feign-client.user-service.address}"+":${my.feign-client.user-service.port}"+"${my.feign-client.user-service.end-point}")
public interface UserClient {

    @GetMapping("/login")
    UserRelationTypeInfo getUserLoginByName(@RequestParam(name = "name") String userName);

    @GetMapping("/relation-type")
    UserRelationTypeInfo getUserRelationTypeByName(@RequestParam(name = "name") String userName);

    @GetMapping("/")
    boolean validateById(@PathVariable("id") long userId);
}