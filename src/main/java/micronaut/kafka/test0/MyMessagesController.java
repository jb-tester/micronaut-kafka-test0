package micronaut.kafka.test0;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import java.util.List;

@Controller
public class MyMessagesController {

    @Inject
    MyMessageProducer producer;
    @Inject MyMessagesRepo repo;

    @Get("/count")
    public int getCount(){
        return repo.getCount();
    }
    @Get("/messages")
    public List<String> getAllMessages() {
        return repo.getMessages();
    }

    @Post("/add1/{key}/{message}")
    public void sendMessage1(@PathVariable("key") String key, @PathVariable("message") String message) {
        producer.sendMessage(key, message);
    }
    @Post("/add2/{key}/{message}")
    public void sendMessage2(@PathVariable("key") String key, @PathVariable("message") String message) {
        producer.sendMessage("my-messages",key, message);  // topic id not a reference here
    }
    @Post("/add3/{key}/{message}")
    public void sendMessage3(@PathVariable("key") String key, @PathVariable("message") String message) {
        producer.sendNewMessage(key, message);
    }
    @Post("/add4/{key}/{message}")
    public void sendMessage4(@PathVariable("key") String key, @PathVariable("message") String message) {
        producer.sendNewMessage(MyMessageProducer.TOPIC2,key, message);
    }
}
