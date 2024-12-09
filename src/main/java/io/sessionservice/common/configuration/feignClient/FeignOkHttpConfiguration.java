package io.sessionservice.common.configuration.feignClient;

import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 10.
 */
@Configuration
public class FeignOkHttpConfiguration {

    //switch it to use PATCH method
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}