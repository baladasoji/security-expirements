package net.dasoji.webfinger;
import java.util.Arrays ;
import java.util.List ;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Component
@ConfigurationProperties("jwks")
public class JWKSConfig
{
  private List<JWKey> keys;

  /**
  * Returns value of keys
  * @return
  */
  public List<JWKey> getKeys() {
    return keys;
  }

  /**
  * Sets new value of keys
  * @param
  */
  public void setKeys(List<JWKey> keys) {
    this.keys = keys;
  }

}
