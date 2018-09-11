package com.acg.common.beans;

import java.io.Serializable;

public class ErrorMessageBean implements Serializable {
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ErrorMessageBean(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public ErrorMessageBean() {
		super();
		this.errorMessage = "";
	}

}
