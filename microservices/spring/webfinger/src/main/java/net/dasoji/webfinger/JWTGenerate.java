package net.dasoji.webfinger;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import java.io.IOException;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;

public class JWTGenerate
{
  private static final String PRIVATE_KEY_FILE_RSA = "src/main/resources/certs/privkey8.pem";
  private static final String PUBLIC_KEY_FILE_RSA = "src/main/resources/certs/pubkey.pem";
  private static final Logger logger = LoggerFactory.getLogger(JWTGenerate.class);

  public String getToken()
  {
      try {
      RSAPrivateKey privateKey = (RSAPrivateKey) PemUtils.readPrivateKeyFromFile(PRIVATE_KEY_FILE_RSA, "RSA");
      RSAPublicKey publicKey = (RSAPublicKey) PemUtils.readPublicKeyFromFile(PUBLIC_KEY_FILE_RSA, "RSA");
      logger.debug ("Public key info " + publicKey.getModulus());
      logger.debug ("private key info " + privateKey.getModulus());
      logger.debug ("Public key algorithm " + publicKey.getAlgorithm());
      logger.debug ("private key algorithm " + privateKey.getAlgorithm());
      Algorithm algorithm = Algorithm.RSA256(publicKey,privateKey);
      String[] roles = { "booking", "finance", "documentation", "import", "printbills" };
      String token = JWT.create()
          .withIssuer("https://login.dasoji.net")
          .withKeyId("B36D568F46A3AA89BA98FDFD73F99837D2A1C6D4")
          .withClaim("firstname","Bala")
          .withClaim("lastname","Dasoji")
          .withSubject("bala.dasoji@maersk.com")
          .withIssuedAt(new Date(System.currentTimeMillis()))
          .withExpiresAt(new Date(System.currentTimeMillis()+60000))
          .withArrayClaim("roles",roles)
          .sign(algorithm);
          return token;
      } catch (JWTCreationException exception){
        logger.error("error creating jwt ", exception);
          //Invalid Signing configuration / Couldn't convert Claims.
      } catch (IOException ioe){
        logger.error("error reading the private key",ioe);
      }
      catch (Exception e){
        logger.error("General Error",e);
      }
      return null ;
  }
}
