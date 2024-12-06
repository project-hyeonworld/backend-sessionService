package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.api.session.event.kafka.producer.authentication.login.toPartyDashboard.ToPartyDashboardEvent;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.toUser.ToUserEvent;
import io.sessionservice.common.event.CustomEvent;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducers;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 6.
 */
@Component
public class LoginKafkaProducers extends GenericKafkaProducers<LoginEvent> {

    private final Map<Class<?>, Function<LoginEvent<?>, ? extends LoginEvent<?>>> destination;

    public LoginKafkaProducers(
            List<GenericKafkaProducer<? extends LoginEvent, ?, ?>> genericKafkaProducerStrategies) {
        super(genericKafkaProducerStrategies);
        destination = new HashMap<>();
        destination.put(ToPartyDashboardEvent.class, ToPartyDashboardEvent::from);
        destination.put(ToUserEvent.class, ToUserEvent::from);
    }

    @Override
    public void send(LoginEvent event) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        producers.forEach(strategy -> {
            CompletableFuture<Void> future = CompletableFuture.runAsync(createSendTask(strategy, event), executor);
            futures.add(future);
        });
    }

    private Runnable createSendTask(GenericKafkaProducer strategy, LoginEvent<?> event) {
        Class<?> eventClass = strategy.getEventClass();
        Function<LoginEvent<?>, ? extends LoginEvent<?>> convert = destination.get(eventClass);
        if (convert != null) {
            return () -> strategy.send(convert.apply(event));
        }
        return null;
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return LoginEvent.class;
    }
}
