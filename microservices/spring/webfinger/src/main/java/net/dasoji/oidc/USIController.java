package net.dasoji.oidc;

import java.util.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.binary.Base64;
import java.io.IOException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
@RestController
public class USIController {

    @Autowired
    private HttpServletRequest context;
    
    private static final String AUTH_HEADER = "authorization";
    private static final String BEARER_FRAGMENT = "Bearer";
    DecodedJWT jwt = null ;
    String jwtString = null ;
    

    @RequestMapping(value = "/usi", method = RequestMethod.GET, produces = "application/json")
    public String index(HttpServletResponse response) throws IOException {
        String jwtjson = getJWTString();
        return jwtjson;

    }

    private DecodedJWT getJWTfromHeader()
    {
        if (jwt == null )
        {
            String allheaders = "";
            String token="" ;
            Enumeration headerNames = context.getHeaderNames();
            while (headerNames.hasMoreElements()) 
            {
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
                } catch (JWTDecodeException exception){
                    exception.printStackTrace(System.err);
                }
            }
        }
        System.out.println ("Decoded JWT and it is "+jwt);
        return jwt;

    }
    private String getJWTString()
    {
        jwtString = "";
        getJWTfromHeader();
        jwtString = StringUtils.newStringUtf8(Base64.decodeBase64(jwt.getPayload()));
        return jwtString;
    }

}
