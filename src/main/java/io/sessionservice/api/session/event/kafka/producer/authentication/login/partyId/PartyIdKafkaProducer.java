package io.sessionservice.api.session.event.kafka.producer.authentication.login.partyId;

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
@Deprecated
public class PartyIdKafkaProducer extends GenericKafkaProducer<PartyIdMessage, Long, Long> {

    protected PartyIdKafkaProducer(@Value("${spring.kafka.broker.url}") String brokerUrl, @Value("${spring.kafka.topic.session.authentication.log-in.party-id}")String topic) {
        super(topic);
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        kafkaProducer = new KafkaProducer<>(props);
    }

    @Override
    public Class<PartyIdMessage> getEventClass() {
        return PartyIdMessage.class;
    }

    @Override
    public void send(PartyIdMessage event) {
        kafkaProducer.send(produce(event));
    }

    @Override
    protected ProducerRecord<Long, Long> produce(PartyIdMessage event) {
        return convertToRecord(event);
    }

    @Override
    protected ProducerRecord<Long, Long> convertToRecord(PartyIdMessage event) {
        return new ProducerRecord<>(TOPIC, event.userId(), event.getRecordValue());
    }
}
