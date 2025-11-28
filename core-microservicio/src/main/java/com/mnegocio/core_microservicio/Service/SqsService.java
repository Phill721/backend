package com.mnegocio.core_microservicio.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class SqsService {

    private final SqsClient sqsClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${SQS_QUEUE_URL}")
    private String queueUrl;

    public SqsService(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    public void sendProductCreatedEvent(Object payload) {
        try {
            String body = objectMapper.writeValueAsString(payload);
            SendMessageRequest req = SendMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .messageBody(body)
                    .build();
            sqsClient.sendMessage(req);
        } catch (Exception e) {
            // Loguear pero no romper la creación de producto
            e.printStackTrace();
        }
    }
}