package com.andrewwish.b2c.sale.service;

import com.andrewwish.b2c.sale.api.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
@AllArgsConstructor
public class MessagePublisher {

    private final ObjectMapper kafkaObjectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String topic = "b2c.sale";

    @SneakyThrows
    public void publishMessage(Message message) {
        String payload = kafkaObjectMapper.writeValueAsString(message.getPayload());
        log.debug("Exporting message {}", payload);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message.getKey(), payload);
        future.addCallback(new KafkaCallback());
    }

    private class KafkaCallback implements ListenableFutureCallback<SendResult<String, String>> {
        @Override
        public void onFailure(Throwable ex) {
            log.info("Unable to export message", ex);
        }

        @Override
        public void onSuccess(SendResult<String, String> result) {
            log.info("Message was successfully exported: " + result);
        }
    }
}
