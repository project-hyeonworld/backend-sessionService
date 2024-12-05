package io.sessionservice.api.session.client.party;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@FeignClient(name = "party-service", url = "${my.feign-client.party-service.address}"+":${my.feign-client.party-service.port}"+"${my.feign-client.party-service.end-point}")
public interface PartyClient {

    @GetMapping
    Long getByRelationType(@RequestParam("relation-type") int relationType);

}
