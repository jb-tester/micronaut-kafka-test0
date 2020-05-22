package micronaut.kafka.test0;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.Body;

@KafkaClient("messages-producer") // no reference to producer id
public interface MyMessageProducer {

    String TOPIC2 = "my-new-messages";

    @Topic("my-messages")
    void sendMessage(@KafkaKey String messageKey, @Body String message );

    void sendMessage(@Topic String topic, @KafkaKey String messageKey, String message);

    @Topic(TOPIC2)  // usage in listener is not navigated by this gutter
    void sendNewMessage(@KafkaKey String messageKey, @Body String message );

    void sendNewMessage(@Topic String topic, @KafkaKey String messageKey, String message);
}
