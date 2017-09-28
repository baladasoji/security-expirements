package hello;

import java.util.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

@Autowired
private HttpServletRequest context;

    @RequestMapping("/")
    public String index() {
	String allheaders = "";
	Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames = context.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = context.getHeader(key);
	    allheaders = allheaders + key + value + "\r" ;
	}
        return "Greetings from Spring Boot! for Mr Dasoji" +allheaders;
    }

}
