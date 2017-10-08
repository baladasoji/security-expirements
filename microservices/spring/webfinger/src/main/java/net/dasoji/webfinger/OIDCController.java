package net.dasoji.webfinger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class OIDCController {

    @RequestMapping("/oauth2/token")
    public String getToken() {
      return new JWTGenerate().getToken();
    }

}
