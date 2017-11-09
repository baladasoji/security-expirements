package com.maersk.usi.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SessionEntities {

    private String message;
    private SessionInfo sessionDetails ;

    public SessionEntities() {
    }

/*    @Override
    public String toString() {
        return "This is ession entities " + message;
    }
*/
	/**
	* Returns value of message
	* @return
	*/
	public String getMessage() {
		return message;
	}

	/**
	* Sets new value of message
	* @param
	*/
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	* Returns value of sessionEntities
	* @return
	*/
	public SessionInfo getSessionDetails() {
		return sessionDetails;
	}

	/**
	* Sets new value of sessionEntities
	* @param
	*/
	public void setSessionDetails(SessionInfo sessionDetails) {
		this.sessionDetails = sessionDetails;
	}
}
