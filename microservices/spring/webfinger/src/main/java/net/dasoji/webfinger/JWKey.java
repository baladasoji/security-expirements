package net.dasoji.webfinger;
import java.util.List;

public class JWKey
{
  private String kty;
  private String use;
  private String kid;
  private String x5t;
  private String n;
  private String e;
  private List<String> x5c;


	/**
	* Returns value of use
	* @return
	*/
	public String getKty() {
		return kty;
	}
	/**
	* Sets new value of kty
	* @param
	*/
	public void setKty(String kty) {
		this.kty = kty;
	}

	/**
	* Returns value of use
	* @return
	*/
	public String getUse() {
		return use;
	}

	/**
	* Sets new value of use
	* @param
	*/
	public void setUse(String use) {
		this.use = use;
	}

	/**
	* Returns value of kid
	* @return
	*/
	public String getKid() {
		return kid;
	}

	/**
	* Sets new value of kid
	* @param
	*/
	public void setKid(String kid) {
		this.kid = kid;
	}

	/**
	* Returns value of x5t
	* @return
	*/
	public String getX5t() {
		return x5t;
	}

	/**
	* Sets new value of x5t
	* @param
	*/
	public void setX5t(String x5t) {
		this.x5t = x5t;
	}

	/**
	* Returns value of n
	* @return
	*/
	public String getN() {
		return n;
	}

	/**
	* Sets new value of n
	* @param
	*/
	public void setN(String n) {
		this.n = n;
	}

	/**
	* Returns value of e
	* @return
	*/
	public String getE() {
		return e;
	}

	/**
	* Sets new value of e
	* @param
	*/
	public void setE(String e) {
		this.e = e;
	}
  /**
	* Returns value of x4c
	* @return
	*/
	public List<String> getX5c() {
		return x5c;
	}

	/**
	* Sets new value of x4c
	* @param
	*/
	public void setX5c(List<String> x5c) {
		this.x5c = x5c;
	}

}
