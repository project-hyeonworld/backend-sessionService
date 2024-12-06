package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.api.session.event.kafka.producer.authentication.login.toPartyDashboard.ToPartyDashboardEvent;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.toPartyDashboard.ToPartyDashboardEventImpl;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.toUser.ToUserEvent;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.toUser.ToUserEventImpl;
import io.sessionservice.common.event.CustomEvent;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducers;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 6.
 */
@Component
public class LoginKafkaProducers extends GenericKafkaProducers<LoginEvent> {

    public LoginKafkaProducers(
            List<GenericKafkaProducer<? extends LoginEvent, ?, ?>> genericKafkaProducerStrategies) {
        super(genericKafkaProducerStrategies);
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return LoginEvent.class;
    }

    @Override
    public void send(LoginEvent event) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        strategies.forEach(strategy -> {
            CompletableFuture<Void> future = CompletableFuture.runAsync(createSendTask(strategy, event), executor);
            futures.add(future);
        });
    }

    private Runnable createSendTask(GenericKafkaProducer strategy, LoginEvent event) {
        if (strategy.getEventClass().equals(ToUserEvent.class)) {
            return () -> {
                strategy.send(ToUserEventImpl.from(event));
            };
        }
        if (strategy.getEventClass().equals(ToPartyDashboardEvent.class)) {
            return () -> {
                strategy.send(ToPartyDashboardEventImpl.from(event));
            };
        }
        return null;
    }
}
