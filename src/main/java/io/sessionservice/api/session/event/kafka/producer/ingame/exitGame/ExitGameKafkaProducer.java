package io.sessionservice.api.session.event.kafka.producer.ingame.exitGame;

import io.sessionservice.api.session.event.kafka.producer.ingame.enterGame.EnterGameMessage;
import io.sessionservice.api.session.event.kafka.producer.ingame.exitGame.event.ExitGameEvent;
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
public class ExitGameKafkaProducer extends GenericKafkaProducer<ExitGameEvent, Long, ExitGameEventRecord> {

    protected ExitGameKafkaProducer(@Value("${spring.kafka.broker.url}") String brokerUrl, @Value("${spring.kafka.topic.session.in-game.exit-game}")String topic) {
        super(topic);
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ObjectSerializer.class.getName());
        kafkaProducer = new KafkaProducer<>(props);
    }

    @Override
    public Class<ExitGameEvent> getEventClass() {
        return ExitGameEvent.class;
    }

    @Override
    public void send(ExitGameEvent event) {

    }

    @Override
    protected ProducerRecord<Long, ExitGameEventRecord> produce(ExitGameEvent event) {
        return convertToRecord(event);
    }

    @Override
    protected ProducerRecord<Long, ExitGameEventRecord> convertToRecord(ExitGameEvent event) {
        ExitGameMessage message = (ExitGameMessage) event;
        return new ProducerRecord<>(TOPIC, 0, message.userId(), message.getRecordValue());
    }
}
