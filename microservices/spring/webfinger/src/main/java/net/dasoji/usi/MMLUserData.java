package net.dasoji.usi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MMLUserData {
    private boolean loggedIn;
    private String userId;
    private String userName;
    private String customerCode;
    private String companyName;
    private boolean hasMultipleCustomerCodes;

    public MMLUserData() {
    }


	/**
	* Returns value of loggedIn
	* @return
	*/
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	* Sets new value of loggedIn
	* @param
	*/
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	/**
	* Returns value of userId
	* @return
	*/
	public String getUserId() {
		return userId;
	}

	/**
	* Sets new value of userId
	* @param
	*/
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	* Returns value of userName
	* @return
	*/
	public String getUserName() {
		return userName;
	}

	/**
	* Sets new value of userName
	* @param
	*/
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	* Returns value of customerCode
	* @return
	*/
	public String getCustomerCode() {
		return customerCode;
	}

	/**
	* Sets new value of customerCode
	* @param
	*/
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	/**
	* Returns value of companyName
	* @return
	*/
	public String getCompanyName() {
		return companyName;
	}

	/**
	* Sets new value of companyName
	* @param
	*/
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	* Returns value of hasMultipleCustomerCodes
	* @return
	*/
	public boolean isHasMultipleCustomerCodes() {
		return hasMultipleCustomerCodes;
	}

	/**
	* Sets new value of hasMultipleCustomerCodes
	* @param
	*/
	public void setHasMultipleCustomerCodes(boolean hasMultipleCustomerCodes) {
		this.hasMultipleCustomerCodes = hasMultipleCustomerCodes;
	}
}
