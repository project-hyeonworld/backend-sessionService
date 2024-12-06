package io.sessionservice.api.session.event.kafka.producer.authentication.login.toPartyDashboard;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import java.util.Properties;
import java.util.UUID;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class ToPartyDashboardKafkaProducer extends GenericKafkaProducer<ToPartyDashboardEvent, String, Long> {

    protected ToPartyDashboardKafkaProducer(@Value("${spring.kafka.broker.url}") String brokerUrl, @Value("${spring.kafka.topic.session.authentication.log-in.to-partyDashboard}")String topic) {
        super(topic);
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        kafkaProducer = new KafkaProducer<>(props);
    }

    @Override
    public Class<ToPartyDashboardEvent> getEventClass() {
        return ToPartyDashboardEvent.class;
    }

    @Override
    public void send(ToPartyDashboardEvent event) {
        kafkaProducer.send(produce(event));
    }

    @Override
    protected ProducerRecord<String, Long> produce(ToPartyDashboardEvent event) {
        return convertToRecord(event);
    }

    @Override
    protected ProducerRecord<String, Long> convertToRecord(ToPartyDashboardEvent event) {
        return new ProducerRecord<>(TOPIC, UUID.randomUUID().toString(), event.partyId());
    }
}
