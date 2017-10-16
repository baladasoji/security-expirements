package net.dasoji.usi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MMLUserInfo {

    private MMLUserData userData;

    public MMLUserInfo() {
    }


	/**
	* Returns value of userData
	* @return
	*/
	public MMLUserData getUserData() {
		return userData;
	}

	/**
	* Sets new value of userData
	* @param
	*/
	public void setUserData(MMLUserData userData) {
		this.userData = userData;
	}
}
