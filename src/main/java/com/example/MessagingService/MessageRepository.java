package com.example.MessagingService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.*;

import java.util.List;

@Repository
public class MessageRepository {
    private final SnsClient snsClient;
    private final String topicArn; // SNS topic ARN

    public MessageRepository(SnsClient snsClient, @Value("${aws.sns.topicArn}") String topicArn) {
        this.snsClient = snsClient;
        this.topicArn = topicArn;
    }

    public void sendMessage(Message message) {
        // Convert Message to a string or JSON
        String messageBody = /* Convert message to string/JSON */;

        PublishRequest request = PublishRequest.builder()
                .topicArn(topicArn)
                .message(messageBody)
                .build();

        snsClient.publish(request);
    }

    public List<Message> receiveMessages() {
        // Implement message retrieval logic (e.g., subscribe to the topic)
        // and parse received messages into Message objects
        // ...

        return /* List of received messages */;
    }
}

