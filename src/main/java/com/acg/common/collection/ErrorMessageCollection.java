package com.acg.common.collection;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.acg.common.beans.ErrorMessageBean;

public class ErrorMessageCollection implements Serializable {
	private Map<String, ErrorMessageBean> errorMessages;

	public ErrorMessageCollection() {
		super();
		this.errorMessages = new HashMap<String,ErrorMessageBean>();
	}

	public void setErrorMessage(String errorMessage, ErrorMessageBean bean) {
		errorMessages.put(errorMessage, bean);
	}

	public ErrorMessageBean getErrorMessage(String errorMessage) {
		return errorMessages.get(errorMessage);
	}

	public int getCount() {
		return errorMessages.size();
	}
}
