package net.dasoji.usi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CombinedInfo {
    private MMLUserInfo mmluserinfo;
    private SessionEntities sessionentities;
    private UserEntities userentities;

    public CombinedInfo() {
    }



	/**
	* Returns value of mmluserinfo
	* @return
	*/
	public MMLUserInfo getMmluserinfo() {
		return mmluserinfo;
	}

	/**
	* Sets new value of mmluserinfo
	* @param
	*/
	public void setMmluserinfo(MMLUserInfo mmluserinfo) {
		this.mmluserinfo = mmluserinfo;
	}

	/**
	* Returns value of sessionentities
	* @return
	*/
	public SessionEntities getSessionentities() {
		return sessionentities;
	}

	/**
	* Sets new value of sessionentities
	* @param
	*/
	public void setSessionentities(SessionEntities sessionentities) {
		this.sessionentities = sessionentities;
	}

	/**
	* Returns value of userentities
	* @return
	*/
	public UserEntities getUserentities() {
		return userentities;
	}

	/**
	* Sets new value of userentities
	* @param
	*/
	public void setUserentities(UserEntities userentities) {
		this.userentities = userentities;
	}
}
