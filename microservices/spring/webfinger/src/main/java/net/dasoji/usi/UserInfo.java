package net.dasoji.usi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {

    private String userId;
    private String name;
    private String firstName;
    private String lastName;
    private String city;
    private String country;
    private String gaUserId;
    private String scvPersonId;
    private String officeName;
    private String email;
    private Integer userType;

    public UserInfo() {
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
	* Returns value of name
	* @return
	*/
	public String getName() {
		return name;
	}

	/**
	* Sets new value of name
	* @param
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Returns value of firstName
	* @return
	*/
	public String getFirstName() {
		return firstName;
	}

	/**
	* Sets new value of firstName
	* @param
	*/
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	* Returns value of lastName
	* @return
	*/
	public String getLastName() {
		return lastName;
	}

	/**
	* Sets new value of lastName
	* @param
	*/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	* Returns value of city
	* @return
	*/
	public String getCity() {
		return city;
	}

	/**
	* Sets new value of city
	* @param
	*/
	public void setCity(String city) {
		this.city = city;
	}

	/**
	* Returns value of country
	* @return
	*/
	public String getCountry() {
		return country;
	}

	/**
	* Sets new value of country
	* @param
	*/
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	* Returns value of gaUserId
	* @return
	*/
	public String getGaUserId() {
		return gaUserId;
	}

	/**
	* Sets new value of gaUserId
	* @param
	*/
	public void setGaUserId(String gaUserId) {
		this.gaUserId = gaUserId;
	}

	/**
	* Returns value of scvPersonId
	* @return
	*/
	public String getScvPersonId() {
		return scvPersonId;
	}

	/**
	* Sets new value of scvPersonId
	* @param
	*/
	public void setScvPersonId(String scvPersonId) {
		this.scvPersonId = scvPersonId;
	}

	/**
	* Returns value of officeName
	* @return
	*/
	public String getOfficeName() {
		return officeName;
	}

	/**
	* Sets new value of officeName
	* @param
	*/
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	* Returns value of email
	* @return
	*/
	public String getEmail() {
		return email;
	}

	/**
	* Sets new value of email
	* @param
	*/
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	* Returns value of userType
	* @return
	*/
	public Integer getUserType() {
		return userType;
	}

	/**
	* Sets new value of userType
	* @param
	*/
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
}
