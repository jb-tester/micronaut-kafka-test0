package micronaut.kafka.test0;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("my.messages")
public class MyConfProps {
    String extraTopic;

    public String getExtraTopic() {
        return extraTopic;
    }

    public void setExtraTopic(String extraTopic) {
        this.extraTopic = extraTopic;
    }
}
