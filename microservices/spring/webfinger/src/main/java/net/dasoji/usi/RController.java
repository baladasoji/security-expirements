package net.dasoji.usi;

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
import com.fasterxml.jackson.databind.ObjectMapper;
import net.dasoji.webfinger.JWTGenerate;
@RestController
public class RController {

	private static final Logger log = LoggerFactory.getLogger(RController.class);
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
      return builder.build();
    }

		@RequestMapping(value = "/authorize", method = RequestMethod.GET, produces = "application/json")
		public CombinedToken authorize(RestTemplate restTemplate, @RequestHeader HttpHeaders headers) {
			log.debug(headers.getFirst(HttpHeaders.COOKIE));
			HttpHeaders nh = new HttpHeaders();
			nh.set(HttpHeaders.COOKIE,headers.getFirst(HttpHeaders.COOKIE));
			nh.set(HttpHeaders.USER_AGENT,"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
			HttpEntity he = new HttpEntity(nh);
			//MMLUserInfo ue = restTemplate.getForObject ("http://localhost/mmlinfo", MMLUserInfo.class, he);
			ResponseEntity<String> usiuser = restTemplate.exchange ("https://my-demo.maerskline.com/agent-api/getuser", HttpMethod.GET, he, String.class);
			ResponseEntity<String> usisession = restTemplate.exchange ("https://my-demo.maerskline.com/agent-api/getsessioninfo", HttpMethod.GET, he, String.class);
			ResponseEntity<String> sspuser = restTemplate.exchange ("https://my-demo.maerskline.com/common/rest/userinfo", HttpMethod.GET, he, String.class);
			ObjectMapper objectMapper = new ObjectMapper();
			UserEntities userEntities = null ;
			SessionEntities sessionEntities = null ;
			MMLUserInfo mmlUserinfo = null ;
			if (usiuser.getStatusCode() == HttpStatus.OK && usisession.getStatusCode() == HttpStatus.OK && sspuser.getStatusCode() == HttpStatus.OK )
			{
				try
				{
				 userEntities = objectMapper.readValue(usiuser.getBody(), UserEntities.class);
				 sessionEntities = objectMapper.readValue(usisession.getBody(), SessionEntities.class);
				 mmlUserinfo = objectMapper.readValue(sspuser.getBody(), MMLUserInfo.class);
				}
				catch (Exception e)
				{
					log.error(e.getMessage());
				}
			}
			CombinedToken token = new CombinedToken();
			JWTGenerate jg = new JWTGenerate();
			token.setId_token(jg.getIdToken(mmlUserinfo.getUserData(),sessionEntities.getSessionEntities(),userEntities.getUserEntities()));
			token.setAccess_token(jg.getAccessToken(mmlUserinfo.getUserData(),sessionEntities.getSessionEntities(),userEntities.getUserEntities()));
			token.setToken_type("Bearer");
			token.setExpires_in(3600);

			return token;
			//UserEntities ue = restTemplate.getForObject ("http://localhost/userinfo", UserEntities.class);
			//return ue;
		}
		@RequestMapping(value = "/allrest", method = RequestMethod.GET, produces = "application/json")
		public CombinedInfo allrest(RestTemplate restTemplate, @RequestHeader HttpHeaders headers) {
			log.debug(headers.getFirst(HttpHeaders.COOKIE));
			HttpHeaders nh = new HttpHeaders();
			nh.set(HttpHeaders.COOKIE,headers.getFirst(HttpHeaders.COOKIE));
			nh.set(HttpHeaders.USER_AGENT,"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
			HttpEntity he = new HttpEntity(nh);
			//MMLUserInfo ue = restTemplate.getForObject ("http://localhost/mmlinfo", MMLUserInfo.class, he);
			ResponseEntity<String> usiuser = restTemplate.exchange ("https://my-demo.maerskline.com/agent-api/getuser", HttpMethod.GET, he, String.class);
			ResponseEntity<String> usisession = restTemplate.exchange ("https://my-demo.maerskline.com/agent-api/getsessioninfo", HttpMethod.GET, he, String.class);
			ResponseEntity<String> sspuser = restTemplate.exchange ("https://my-demo.maerskline.com/common/rest/userinfo", HttpMethod.GET, he, String.class);
			ObjectMapper objectMapper = new ObjectMapper();
			UserEntities userEntities = null ;
			SessionEntities sessionEntities = null ;
			MMLUserInfo mmlUserinfo = null ;
			if (usiuser.getStatusCode() == HttpStatus.OK && usisession.getStatusCode() == HttpStatus.OK && sspuser.getStatusCode() == HttpStatus.OK )
			{
				try
				{
				 userEntities = objectMapper.readValue(usiuser.getBody(), UserEntities.class);
				 sessionEntities = objectMapper.readValue(usisession.getBody(), SessionEntities.class);
				 mmlUserinfo = objectMapper.readValue(sspuser.getBody(), MMLUserInfo.class);
				}
				catch (Exception e)
				{
					log.error(e.getMessage());
				}
			}
			CombinedInfo ci = new CombinedInfo();
			ci.setMmluserinfo(mmlUserinfo);
			ci.setUserentities(userEntities);
			ci.setSessionentities(sessionEntities);
			return ci;
			//UserEntities ue = restTemplate.getForObject ("http://localhost/userinfo", UserEntities.class);
			//return ue;
		}





    @RequestMapping(value = "/userinfo", method = RequestMethod.GET, produces = "application/json")
    public UserEntities user(RestTemplate restTemplate, @RequestHeader HttpHeaders headers) {
      log.debug(headers.getFirst(HttpHeaders.COOKIE));
      HttpHeaders nh = new HttpHeaders();
      nh.set(HttpHeaders.COOKIE,headers.getFirst(HttpHeaders.COOKIE));
      nh.set(HttpHeaders.USER_AGENT,"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
      HttpEntity he = new HttpEntity(nh);
      //MMLUserInfo ue = restTemplate.getForObject ("http://localhost/mmlinfo", MMLUserInfo.class, he);
      ResponseEntity<String> ue = restTemplate.exchange ("https://my.maerskline.com/agent-api/getuser", HttpMethod.GET, he, String.class);
      ObjectMapper objectMapper = new ObjectMapper();
      UserEntities mi = null ;
      if (ue.getStatusCode() == HttpStatus.OK )
      {
        try
        {
         mi = objectMapper.readValue(ue.getBody(), UserEntities.class);
        }
        catch (Exception e)
        {
          log.error(e.getMessage());
        }
      }
        return mi;
      //UserEntities ue = restTemplate.getForObject ("http://localhost/userinfo", UserEntities.class);
      //return ue;
    }


    @RequestMapping(value = "/sessioninfo", method = RequestMethod.GET, produces = "application/json")
    public SessionEntities session(RestTemplate restTemplate, @RequestHeader HttpHeaders headers) {
      log.debug(headers.getFirst(HttpHeaders.COOKIE));
      HttpHeaders nh = new HttpHeaders();
      nh.set(HttpHeaders.COOKIE,headers.getFirst(HttpHeaders.COOKIE));
      nh.set(HttpHeaders.USER_AGENT,"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
      HttpEntity he = new HttpEntity(nh);
      //MMLUserInfo ue = restTemplate.getForObject ("http://localhost/mmlinfo", MMLUserInfo.class, he);
      ResponseEntity<String> ue = restTemplate.exchange ("https://my.maerskline.com/agent-api/getsessioninfo", HttpMethod.GET, he, String.class);
      ObjectMapper objectMapper = new ObjectMapper();
      SessionEntities mi = null ;
      if (ue.getStatusCode() == HttpStatus.OK)
      {
        try
        {
         mi = objectMapper.readValue(ue.getBody(), SessionEntities.class);
        }
        catch (Exception e)
        {
          log.error(e.getMessage());
        }
      }

      //return ue.getBody();
      return mi;
//      SessionEntities se = restTemplate.getForObject ("http://localhost/sessioninfo", SessionEntities.class);
//      return se;
    }

    @RequestMapping(value = "/mmlinfo", method = RequestMethod.GET, produces = "application/json")
    public MMLUserInfo mmlinfo(RestTemplate restTemplate, @RequestHeader HttpHeaders headers) {
      log.debug(headers.getFirst(HttpHeaders.COOKIE));
      HttpHeaders nh = new HttpHeaders();
      nh.set(HttpHeaders.COOKIE,headers.getFirst(HttpHeaders.COOKIE));
      nh.set(HttpHeaders.USER_AGENT,"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
      HttpEntity he = new HttpEntity(nh);
      //MMLUserInfo ue = restTemplate.getForObject ("http://localhost/mmlinfo", MMLUserInfo.class, he);
      ResponseEntity<String> ue = restTemplate.exchange ("https://my.maerskline.com/common/rest/userinfo", HttpMethod.GET, he, String.class);
      ObjectMapper objectMapper = new ObjectMapper();
      MMLUserInfo mi = null ;
      if (ue.getStatusCode() == HttpStatus.OK)
      {
        try
        {
          mi = objectMapper.readValue(ue.getBody(), MMLUserInfo.class);
        }
        catch (Exception e)
        {
          log.error(e.getMessage());
        }
      }

      //return ue.getBody();
      return mi;
    }

}
