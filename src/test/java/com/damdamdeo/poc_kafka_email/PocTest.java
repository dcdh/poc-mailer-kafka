package com.damdamdeo.poc_kafka_email;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class PocTest {

    @Inject
    KafkaSimpleProducer kafkaSimpleProducer;

    @Test
    public void should_exit_normally_after_test() throws Exception {
        kafkaSimpleProducer.produce("key", "value");
        Assertions.assertTrue(true);
    }

}
