package io.sessionservice.api.session.event.kafka.producer.authentication.logout;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducerStrategy;
import io.sessionservice.common.mapper.ObjectSerializer;
import java.util.Properties;
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
public class LogoutKafkaProducerStrategy extends GenericKafkaProducerStrategy<LogoutEvent, String, LogoutEventImpl> {

    protected LogoutKafkaProducerStrategy(@Value("${spring.kafka.broker.url}") String brokerUrl, @Value("${spring.kafka.topic.session.authentication.log-out}")String topic) {
        super(topic);
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ObjectSerializer.class.getName());
        kafkaProducer = new KafkaProducer<>(props);
    }

    @Override
    public Class<LogoutEvent> getEventClass() {
        return LogoutEvent.class;
    }

    @Override
    protected ProducerRecord<String, LogoutEventImpl> convertToRecord(LogoutEvent event) {
        return new ProducerRecord<>(TOPIC, (LogoutEventImpl)event);
    }
}