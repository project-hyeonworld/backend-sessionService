package io.sessionservice.api.session.event.kafka.producer.ingame.enterGame;

import io.sessionservice.api.session.event.kafka.producer.authentication.login.LoginEventRecord;
import io.sessionservice.api.session.event.kafka.producer.ingame.enterGame.event.EnterGameEvent;
import io.sessionservice.common.event.kafka.producer.GenericKafkaProducer;
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
public class EnterGameKafkaProducer extends GenericKafkaProducer<EnterGameEvent, Long, EnterGameEventRecord> {

    protected EnterGameKafkaProducer(@Value("${spring.kafka.broker.url}") String brokerUrl, @Value("${spring.kafka.topic.session.in-game.enter-game}")String topic) {
        super(topic);
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ObjectSerializer.class.getName());
        kafkaProducer = new KafkaProducer<>(props);
    }

    @Override
    public Class<EnterGameEvent> getEventClass() {
        return EnterGameEvent.class;
    }

    @Override
    public void send(EnterGameEvent event) {
        kafkaProducer.send(produce(event));
    }

    @Override
    protected ProducerRecord<Long, EnterGameEventRecord> produce(EnterGameEvent event) {
        return convertToRecord(event);
    }

    @Override
    protected ProducerRecord<Long, EnterGameEventRecord> convertToRecord(EnterGameEvent event) {
        EnterGameMessage message = (EnterGameMessage) event;
        return new ProducerRecord<>(TOPIC, 0, message.userId(), message.getRecordValue());
    }
}
