package io.sessionservice.api.session.event.kafka.producer.authentication.login.toPartyDashboard;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class ToPartyDashboardKafkaProducer extends GenericKafkaProducer<ToPartyDashboardEvent, Long, Long> {

    protected ToPartyDashboardKafkaProducer(@Value("${spring.kafka.broker.url}") String brokerUrl, @Value("${spring.kafka.topic.session.authentication.log-in.to-partyDashboard}")String topic) {
        super(topic);
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
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
    protected ProducerRecord<Long, Long> produce(ToPartyDashboardEvent event) {
        return convertToRecord(event);
    }

    @Override
    protected ProducerRecord<Long, Long> convertToRecord(ToPartyDashboardEvent event) {
        return new ProducerRecord<>(TOPIC, event.userId(), event.getRecordValue());
    }
}
