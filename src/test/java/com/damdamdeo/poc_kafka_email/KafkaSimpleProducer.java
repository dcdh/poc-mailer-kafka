package com.damdamdeo.poc_kafka_email;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class KafkaSimpleProducer {

    @ConfigProperty(name = "smallrye.messaging.source.event.bootstrap.servers")
    String servers;

    private KafkaProducer<String, String> producer;

    @PostConstruct
    public void init() {
        final Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.ACKS_CONFIG, "1");
        producer = new KafkaProducer(config);
    }

    public void produce(final String key, final String value) throws Exception {
        producer.send(new ProducerRecord<>("event", key, value)).get();
    }

}
