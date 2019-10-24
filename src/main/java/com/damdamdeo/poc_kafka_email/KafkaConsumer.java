package com.damdamdeo.poc_kafka_email;

import io.smallrye.reactive.messaging.kafka.KafkaMessage;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class KafkaConsumer {

    @Incoming("event")
    public CompletionStage<Void> onMessage(final KafkaMessage<String, String> message) throws Exception {
        return message.ack();
    }

}
