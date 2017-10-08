package net.dasoji;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class GreetingController {

    @Autowired
    private Greeting greeting;
    @RequestMapping("/greeting")
    public Greeting greeting() {
       // return new Greeting(counter.incrementAndGet(), String.format(template, name));
        return greeting;
    }

}
