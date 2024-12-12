package io.sessionservice.api.session.event.kafka.producer.authentication.login;

import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
import io.sessionservice.common.mapper.ObjectSerializer;
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
public class LoginKafkaProducer extends
        GenericKafkaProducer<LoginEvent, Long, LoginEventRecord>  {

    protected LoginKafkaProducer(@Value("${spring.kafka.broker.url}") String brokerUrl, @Value("${spring.kafka.topic.session.authentication.log-in}")String topic) {
        super(topic);
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ObjectSerializer.class.getName());
        kafkaProducer = new KafkaProducer<>(props);
    }

    @Override
    public Class<LoginEvent> getEventClass() {
        return LoginEvent.class;
    }

    @Override
    public void send(LoginEvent event) {
        kafkaProducer.send(produce(event));
    }

    @Override
    protected ProducerRecord<Long, LoginEventRecord> produce(LoginEvent event) {
        return convertToRecord(event);
    }

    @Override
    protected ProducerRecord<Long, LoginEventRecord> convertToRecord(LoginEvent event) {
        LoginMessage message = (LoginMessage) event;
        return new ProducerRecord<>(TOPIC, 0, message.userId(), message.getRecordValue());
    }

}
