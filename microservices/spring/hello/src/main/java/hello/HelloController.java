package hello;

import java.util.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
@RestController
public class HelloController {

@Autowired
private HttpServletRequest context;

    @RequestMapping("/")
    public String index() {
	String allheaders = "";
	DecodedJWT jwt = null ;
	String token="" ;
	String sub="" ;
	String name ="";
	Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames = context.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = context.getHeader(key);
		if (key.equals("authorization"))
		{
			token=value;
			token = token.substring(7);
			
		}
	    allheaders = allheaders + key + value ;
	}
	if (!token.equals(""))
	{
		try {
		    jwt = JWT.decode(token);
			sub =jwt.getSubject();
			name = jwt.getIssuer();
		} catch (JWTDecodeException exception){
		    exception.printStackTrace(System.err);
		}
	}
        return "Greetings from Spring Boot! for Mr Dasoji JWT is " +jwt + " subject is  " +sub + " Issuer is "+ name;
    }

}
