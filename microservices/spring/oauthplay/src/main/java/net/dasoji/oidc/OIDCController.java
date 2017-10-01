package net.dasoji.oidc;

import java.util.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.binary.Base64;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
@RestController
public class OIDCController {

@Autowired
private HttpServletRequest context;
    
    private static final String AUTH_HEADER = "authorization";
    private static final String BEARER_FRAGMENT = "Bearer";
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String index() {
        return getJWTfromHeader();
    }

    private String getJWTfromHeader()
    {
	DecodedJWT jwt = null ;
	String allheaders = "";
	String token="" ;
        String payloadJson="There was an error decoding the token - Probably you did not provide a valid JWT token in the Authorization header";
        Enumeration headerNames = context.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = context.getHeader(key);
		if (key!=null && key.equals(AUTH_HEADER))
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
                    payloadJson = StringUtils.newStringUtf8(Base64.decodeBase64(jwt.getPayload()));
		} catch (JWTDecodeException exception){
		    exception.printStackTrace(System.err);
		}
	}
        return payloadJson;
    }

}
