package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Deprecated
public class LoginKafkaProducer extends
        GenericKafkaProducer<LoginEvent, Long, Long> implements
        LoginEvent {

    protected LoginKafkaProducer(@Value("${spring.kafka.broker.url}") String brokerUrl, @Value("${spring.kafka.topic.session.authentication.log-in}")String topic) {
        super(topic);
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        kafkaProducer = new KafkaProducer<>(props);
    }

    @Override
    public Class<LoginEvent> getEventClass() {
        return LoginEvent.class;
    }

    @Override
    protected ProducerRecord<Long, Long> convertToRecord(LoginEvent event) {
        LoginEventImpl impl = (LoginEventImpl) event;
        return new ProducerRecord<>(TOPIC, event.userId());
    }

    @Override
    public long userId() {
        return 0;
    }
}
