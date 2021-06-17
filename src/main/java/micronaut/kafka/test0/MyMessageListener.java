package micronaut.kafka.test0;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.SendTo;

import javax.inject.Inject;

import static micronaut.kafka.test0.MyMessageProducer.TOPIC2;

@KafkaListener(groupId = "messages-group")  // no reference to group - https://youtrack.jetbrains.com/issue/IDEA-241620
public class MyMessageListener {
    @Inject
    MyMessagesRepo repo;

    @Topic({"my-messages",TOPIC2})
    @SendTo({"message-logger","${my.messages.extra-topic}"}) // no navigation to property here - https://youtrack.jetbrains.com/issue/IDEA-241615: fixed;
                                                            // check that method has return value - https://youtrack.jetbrains.com/issue/IDEA-241619
    public String receive(@KafkaKey String messagekey, String message) {
        repo.saveMessage(messagekey+" "+message);
        return message;
    }


    @Topic("${my.messages.extra-topic}")  // no gutter icon here etc - https://youtrack.jetbrains.com/issue/IDEA-241613
    public void count(String message){
        repo.count();
    }

    @Topic("message-logger")
    // @Topic("message-counter")
    public void log(String message){
        System.out.println("************************");
        System.out.println(message+ " received!");
        System.out.println("************************");
    }
}
