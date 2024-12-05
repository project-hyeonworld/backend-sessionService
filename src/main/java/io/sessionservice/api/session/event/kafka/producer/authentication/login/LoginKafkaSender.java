package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.api.session.event.kafka.producer.authentication.login.toPartyDashboard.ToPartyDashboardEvent;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.toPartyDashboard.ToPartyDashboardEventImpl;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.toUser.ToUserEvent;
import io.sessionservice.api.session.event.kafka.producer.authentication.login.toUser.ToUserEventImpl;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerManager;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerStrategy;
import io.sessionservice.common.event.kafka.producer.GenericKafkaSender;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class LoginKafkaSender extends GenericKafkaSender<LoginEvent> {

    private final Executor executor;

    public LoginKafkaSender(
            GenericKafkaProducerManager<LoginEvent> kafkaProducerManager) {
        super(kafkaProducerManager);
        executor = Executors.newFixedThreadPool(2);
    }

    @Override
    public void execute(LoginEvent event) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            GenericKafkaProducerStrategy producerForUser = manager.getProducer(ToUserEvent.class);
            producerForUser.send(ToUserEventImpl.from(event));
        }, executor);
        futures.add(future);
        future = CompletableFuture.runAsync(() -> {
            GenericKafkaProducerStrategy producerForPartyDashboard = manager.getProducer(ToPartyDashboardEvent.class);
            producerForPartyDashboard.send(ToPartyDashboardEventImpl.from(event));
        }, executor);
        futures.add(future);
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }

}
