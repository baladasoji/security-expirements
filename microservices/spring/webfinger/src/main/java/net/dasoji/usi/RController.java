package net.dasoji.usi;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletResponse;
import net.dasoji.webfinger.JWTGenerate;
import java.io.IOException;
@RestController
public class RController {

	@Value("${myml.url}")
	private String sspUrl;
	private	ResponseEntity<String> sspUserInfoResponse;
	private	ResponseEntity<String> usiGetUserResponse;
	private	ResponseEntity<String> usiSessionInfoResponse;
	private MMLUserInfo mmlUserInfo = new MMLUserInfo();
	private SessionEntities sessionEntities = new SessionEntities();
	private UserEntities userEntities = new UserEntities();

	private static final Logger log = LoggerFactory.getLogger(RController.class);
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
      return builder.build();
    }


		private boolean populateLegacyObjects(RestTemplate restTemplate, HttpHeaders headers)
		{
			ObjectMapper objectMapper = new ObjectMapper();
			CombinedToken token = new CombinedToken();
			log.debug(headers.getFirst(HttpHeaders.COOKIE));
			log.info("SSP Url is " +sspUrl);
			HttpHeaders nh = new HttpHeaders();
			nh.set(HttpHeaders.COOKIE,headers.getFirst(HttpHeaders.COOKIE));
			nh.set(HttpHeaders.USER_AGENT,headers.getFirst(HttpHeaders.USER_AGENT));
			HttpEntity he = new HttpEntity(nh);
			sspUserInfoResponse = restTemplate.exchange (sspUrl+"/common/rest/userinfo", HttpMethod.GET, he, String.class);
			try
			{
				mmlUserInfo = objectMapper.readValue(sspUserInfoResponse.getBody(), MMLUserInfo.class);
				// Perform other steps only if the user is logged in
				if (validateLogin (mmlUserInfo))
				{
					log.info ("User is logged in");
					usiGetUserResponse = restTemplate.exchange (sspUrl+"/agent-api/getuser", HttpMethod.GET, he, String.class);
					usiSessionInfoResponse = restTemplate.exchange (sspUrl+"/agent-api/getsessioninfo", HttpMethod.GET, he, String.class);
					userEntities = objectMapper.readValue(usiGetUserResponse.getBody(), UserEntities.class);
					sessionEntities = objectMapper.readValue(usiSessionInfoResponse.getBody(), SessionEntities.class);
				}
				else
				{
					log.info ("User is NOT logged in");
					return false;
				}
			}
			catch (Exception e)
			{
				log.error(e.getMessage());
				return false;
			}
			return true;
		}

		private boolean validateLogin(MMLUserInfo mmlUserInfo)
		{
			if (mmlUserInfo != null)
				return mmlUserInfo.getUserData().isLoggedIn();
			else
				return false;
		}

		@RequestMapping(value = "/connect/authorize", method = RequestMethod.GET, produces = "application/json")
		public CombinedToken authorize(RestTemplate restTemplate, @RequestHeader HttpHeaders headers, HttpServletResponse response,
                                        @RequestParam("response_type") String response_type,
                                        @RequestParam("client_id") String client_id,
                                        @RequestParam("redirect_uri") String redirect_uri,
                                        @RequestParam("scope") String scope,
                                        @RequestParam("state") String state,
                                        @RequestParam("nonce") String nonce

                                        ) throws IOException
		{
			CombinedToken token = new CombinedToken();
			// If we could successfully populate the legacy objects then proceed with generating token else return an empty token
			if(populateLegacyObjects(restTemplate, headers))
			{
				JWTGenerate jg = new JWTGenerate();
                String access_token =jg.getAccessToken(mmlUserInfo.getUserData(),sessionEntities.getSessionEntities(),userEntities.getUserEntities());
                String id_token = jg.getIdToken(mmlUserInfo.getUserData(),sessionEntities.getSessionEntities(),userEntities.getUserEntities(),client_id, nonce, access_token ) ;
				token.setId_token(id_token);
				token.setAccess_token(access_token);
				token.setToken_type("Bearer");
				token.setExpires_in(3600);
			}
            else
            {
                response.sendRedirect("https://my.maerskline.com/portaluser/#login?originalUrl=https://autht.maerskline.com/connect/authorize?client_id="+client_id+"&scope="+scope+"&nonce="+nonce);
            }
			return token;
		}



		@RequestMapping(value = "/connect/allrest", method = RequestMethod.GET, produces = "application/json")
		public CombinedInfo allrest(RestTemplate restTemplate, @RequestHeader HttpHeaders headers)
		{
			CombinedInfo ci = new CombinedInfo();
			if(populateLegacyObjects(restTemplate, headers))
			{
				ci.setMmluserinfo(mmlUserInfo);
				ci.setUserentities(userEntities);
				ci.setSessionentities(sessionEntities);
			}
			return ci;
		}



    @RequestMapping(value = "/connect/getuser", method = RequestMethod.GET, produces = "application/json")
    public UserEntities user(RestTemplate restTemplate, @RequestHeader HttpHeaders headers)
		{
			populateLegacyObjects(restTemplate, headers);
			return userEntities;
    }


    @RequestMapping(value = "/connect/sessioninfo", method = RequestMethod.GET, produces = "application/json")
    public SessionEntities session(RestTemplate restTemplate, @RequestHeader HttpHeaders headers)
		{
			populateLegacyObjects(restTemplate, headers);
			return sessionEntities;
    }

    @RequestMapping(value = "/connect/userinfo", method = RequestMethod.GET, produces = "application/json")
    public MMLUserInfo mmlinfo(RestTemplate restTemplate, @RequestHeader HttpHeaders headers)
		{
			populateLegacyObjects(restTemplate, headers);
			return mmlUserInfo;
    }

}
