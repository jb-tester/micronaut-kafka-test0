package micronaut.kafka.test0;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class MyMessagesRepo {

    public List<String> getMessages() {
        return messages;
    }

    List<String> messages = new ArrayList<>();
    int count = 0;
    public void saveMessage(String message){
        messages.add(message);
    }

    public void count() {
       this.count = this.count+1;
    }

    public int getCount() {
        return count;
    }
}
