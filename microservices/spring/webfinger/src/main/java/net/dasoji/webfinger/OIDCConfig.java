package net.dasoji.webfinger;
import java.util.Arrays ;
import java.util.List ;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Component
@ConfigurationProperties("well-known")
public class OIDCConfig {

    private String issuer;
    private String authorization_endpoint;
    private String token_endpoint;
    private List<String> token_endpoint_auth_methods_supported;

    private List<String> token_endpoint_auth_signing_alg_values_supported;
    private String userinfo_endpoint;

    private String jwks_uri;
    private String registration_endpoint;
    private List<String> scopes_supported;
    private List<String> response_types_supported;
    private List<String> response_modes_supported;
    private List<String> acr_values_supported;
    private List<String> userinfo_signing_alg_values_supported;
    private List<String> userinfo_encryption_alg_values_supported;
    private List<String> userinfo_encryption_enc_values_supported;
    private List<String> id_token_signing_alg_values_supported;
    private List<String> id_token_encryption_alg_values_supported;
    private List<String> id_token_encryption_enc_values_supported;
    private List<String> request_object_signing_alg_values_supported;
    private List<String> display_values_supported;
    private List<String> claim_types_supported;
    private List<String> claims_supported;
    private Boolean claims_parameter_supported;


	/**
	* Returns value of issuer
	* @return
	*/
	public String getIssuer() {
		return issuer;
	}

	/**
	* Sets new value of issuer
	* @param
	*/
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	/**
	* Returns value of authorization_endpoint
	* @return
	*/
	public String getAuthorization_endpoint() {
		return authorization_endpoint;
	}

	/**
	* Sets new value of authorization_endpoint
	* @param
	*/
	public void setAuthorization_endpoint(String authorization_endpoint) {
		this.authorization_endpoint = authorization_endpoint;
	}

	/**
	* Returns value of token_endpoint
	* @return
	*/
	public String getToken_endpoint() {
		return token_endpoint;
	}

	/**
	* Sets new value of token_endpoint
	* @param
	*/
	public void setToken_endpoint(String token_endpoint) {
		this.token_endpoint = token_endpoint;
	}

	/**
	* Returns value of token_endpoint_auth_methods_supported
	* @return
	*/
	public List<String> getToken_endpoint_auth_methods_supported() {
		return token_endpoint_auth_methods_supported;
	}

	/**
	* Sets new value of token_endpoint_auth_methods_supported
	* @param
	*/
	public void setToken_endpoint_auth_methods_supported(List<String> token_endpoint_auth_methods_supported) {
		this.token_endpoint_auth_methods_supported = token_endpoint_auth_methods_supported;
	}

	/**
	* Returns value of token_endpoint_auth_signing_alg_values_supported
	* @return
	*/
	public List<String> getToken_endpoint_auth_signing_alg_values_supported() {
		return token_endpoint_auth_signing_alg_values_supported;
	}

	/**
	* Sets new value of token_endpoint_auth_signing_alg_values_supported
	* @param
	*/
	public void setToken_endpoint_auth_signing_alg_values_supported(List<String> token_endpoint_auth_signing_alg_values_supported) {
		this.token_endpoint_auth_signing_alg_values_supported = token_endpoint_auth_signing_alg_values_supported;
	}

	/**
	* Returns value of userinfo_endpoint
	* @return
	*/
	public String getUserinfo_endpoint() {
		return userinfo_endpoint;
	}

	/**
	* Sets new value of userinfo_endpoint
	* @param
	*/
	public void setUserinfo_endpoint(String userinfo_endpoint) {
		this.userinfo_endpoint = userinfo_endpoint;
	}

	/**
	* Returns value of jwks_uri
	* @return
	*/
	public String getJwks_uri() {
		return jwks_uri;
	}

	/**
	* Sets new value of jwks_uri
	* @param
	*/
	public void setJwks_uri(String jwks_uri) {
		this.jwks_uri = jwks_uri;
	}

	/**
	* Returns value of registration_endpoint
	* @return
	*/
	public String getRegistration_endpoint() {
		return registration_endpoint;
	}

	/**
	* Sets new value of registration_endpoint
	* @param
	*/
	public void setRegistration_endpoint(String registration_endpoint) {
		this.registration_endpoint = registration_endpoint;
	}

	/**
	* Returns value of scopes_supported
	* @return
	*/
	public List<String> getScopes_supported() {
		return scopes_supported;
	}

	/**
	* Sets new value of scopes_supported
	* @param
	*/
	public void setScopes_supported(List<String> scopes_supported) {
		this.scopes_supported = scopes_supported;
	}

	/**
	* Returns value of response_types_supported
	* @return
	*/
	public List<String> getResponse_types_supported() {
		return response_types_supported;
	}

	/**
	* Sets new value of response_types_supported
	* @param
	*/
	public void setResponse_types_supported(List<String> response_types_supported) {
		this.response_types_supported = response_types_supported;
	}

	/**
	* Returns value of response_modes_supported
	* @return
	*/
	public List<String> getResponse_modes_supported() {
		return response_modes_supported;
	}

	/**
	* Sets new value of response_modes_supported
	* @param
	*/
	public void setResponse_modes_supported(List<String> response_modes_supported) {
		this.response_modes_supported = response_modes_supported;
	}

	/**
	* Returns value of acr_values_supported
	* @return
	*/
	public List<String> getAcr_values_supported() {
		return acr_values_supported;
	}

	/**
	* Sets new value of acr_values_supported
	* @param
	*/
	public void setAcr_values_supported(List<String> acr_values_supported) {
		this.acr_values_supported = acr_values_supported;
	}

	/**
	* Returns value of userinfo_signing_alg_values_supported
	* @return
	*/
	public List<String> getUserinfo_signing_alg_values_supported() {
		return userinfo_signing_alg_values_supported;
	}

	/**
	* Sets new value of userinfo_signing_alg_values_supported
	* @param
	*/
	public void setUserinfo_signing_alg_values_supported(List<String> userinfo_signing_alg_values_supported) {
		this.userinfo_signing_alg_values_supported = userinfo_signing_alg_values_supported;
	}

	/**
	* Returns value of userinfo_encryption_alg_values_supported
	* @return
	*/
	public List<String> getUserinfo_encryption_alg_values_supported() {
		return userinfo_encryption_alg_values_supported;
	}

	/**
	* Sets new value of userinfo_encryption_alg_values_supported
	* @param
	*/
	public void setUserinfo_encryption_alg_values_supported(List<String> userinfo_encryption_alg_values_supported) {
		this.userinfo_encryption_alg_values_supported = userinfo_encryption_alg_values_supported;
	}

	/**
	* Returns value of userinfo_encryption_enc_values_supported
	* @return
	*/
	public List<String> getUserinfo_encryption_enc_values_supported() {
		return userinfo_encryption_enc_values_supported;
	}

	/**
	* Sets new value of userinfo_encryption_enc_values_supported
	* @param
	*/
	public void setUserinfo_encryption_enc_values_supported(List<String> userinfo_encryption_enc_values_supported) {
		this.userinfo_encryption_enc_values_supported = userinfo_encryption_enc_values_supported;
	}

	/**
	* Returns value of id_token_signing_alg_values_supported
	* @return
	*/
	public List<String> getId_token_signing_alg_values_supported() {
		return id_token_signing_alg_values_supported;
	}

	/**
	* Sets new value of id_token_signing_alg_values_supported
	* @param
	*/
	public void setId_token_signing_alg_values_supported(List<String> id_token_signing_alg_values_supported) {
		this.id_token_signing_alg_values_supported = id_token_signing_alg_values_supported;
	}

	/**
	* Returns value of id_token_encryption_alg_values_supported
	* @return
	*/
	public List<String> getId_token_encryption_alg_values_supported() {
		return id_token_encryption_alg_values_supported;
	}

	/**
	* Sets new value of id_token_encryption_alg_values_supported
	* @param
	*/
	public void setId_token_encryption_alg_values_supported(List<String> id_token_encryption_alg_values_supported) {
		this.id_token_encryption_alg_values_supported = id_token_encryption_alg_values_supported;
	}

	/**
	* Returns value of id_token_encryption_enc_values_supported
	* @return
	*/
	public List<String> getId_token_encryption_enc_values_supported() {
		return id_token_encryption_enc_values_supported;
	}

	/**
	* Sets new value of id_token_encryption_enc_values_supported
	* @param
	*/
	public void setId_token_encryption_enc_values_supported(List<String> id_token_encryption_enc_values_supported) {
		this.id_token_encryption_enc_values_supported = id_token_encryption_enc_values_supported;
	}

	/**
	* Returns value of request_object_signing_alg_values_supported
	* @return
	*/
	public List<String> getRequest_object_signing_alg_values_supported() {
		return request_object_signing_alg_values_supported;
	}

	/**
	* Sets new value of request_object_signing_alg_values_supported
	* @param
	*/
	public void setRequest_object_signing_alg_values_supported(List<String> request_object_signing_alg_values_supported) {
		this.request_object_signing_alg_values_supported = request_object_signing_alg_values_supported;
	}

	/**
	* Returns value of display_values_supported
	* @return
	*/
	public List<String> getDisplay_values_supported() {
		return display_values_supported;
	}

	/**
	* Sets new value of display_values_supported
	* @param
	*/
	public void setDisplay_values_supported(List<String> display_values_supported) {
		this.display_values_supported = display_values_supported;
	}

	/**
	* Returns value of claim_types_supported
	* @return
	*/
	public List<String> getClaim_types_supported() {
		return claim_types_supported;
	}

	/**
	* Sets new value of claim_types_supported
	* @param
	*/
	public void setClaim_types_supported(List<String> claim_types_supported) {
		this.claim_types_supported = claim_types_supported;
	}

	/**
	* Returns value of claims_supported
	* @return
	*/
	public List<String> getClaims_supported() {
		return claims_supported;
	}

	/**
	* Sets new value of claims_supported
	* @param
	*/
	public void setClaims_supported(List<String> claims_supported) {
		this.claims_supported = claims_supported;
	}

	/**
	* Returns value of claims_parameter_supported
	* @return
	*/
	public Boolean getClaims_parameter_supported() {
		return claims_parameter_supported;
	}

	/**
	* Sets new value of claims_parameter_supported
	* @param
	*/
	public void setClaims_parameter_supported(Boolean claims_parameter_supported) {
		this.claims_parameter_supported = claims_parameter_supported;
	}
}
