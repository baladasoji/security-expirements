package net.dasoji.oidc;

import java.util.*;
import javax.servlet.http.*;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.binary.Base64;
import java.io.IOException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;

public class BearerJWTUtil {

    private static final String AUTH_HEADER = "authorization";
    private static final String BEARER_FRAGMENT = "Bearer";
    private static DecodedJWT jwt = null ;
    private static String jwtString = null ;

    public static DecodedJWT getJWTfromHeader(HttpServletRequest request)
    {
        if (jwt == null )
        {
            String allheaders = "";
            String token="" ;
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements())
            {
                String key = (String) headerNames.nextElement();
                String value = request.getHeader(key);
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
    public static String getJWTString(HttpServletRequest request)
    {
        getJWTfromHeader(request);
        jwtString = StringUtils.newStringUtf8(Base64.decodeBase64(jwt.getPayload()));
        return jwtString;
    }

    public static boolean assertRole(HttpServletRequest request, String role)
    {
      jwt=getJWTfromHeader(request);
      return (jwt.getClaim("roles").asString()).contains(role);
    }

}
