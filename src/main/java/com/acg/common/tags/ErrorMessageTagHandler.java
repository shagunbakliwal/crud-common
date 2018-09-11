package com.acg.common.tags;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.acg.common.beans.ErrorMessageBean;
import com.acg.common.collection.ErrorMessageCollection;

public class ErrorMessageTagHandler extends TagSupport {
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int doStartTag() {
		ErrorMessageCollection errorMessageCollection;
		errorMessageCollection = (ErrorMessageCollection) pageContext.getAttribute("errorMessageCollection",
				PageContext.REQUEST_SCOPE);
		if (errorMessageCollection == null || errorMessageCollection.getCount() == 0) {
			return TagSupport.SKIP_BODY;
		}
		ErrorMessageBean errorMessageBean = errorMessageCollection.getErrorMessage(key);
		if (errorMessageBean == null) {
			return TagSupport.SKIP_BODY;
		}
		pageContext.setAttribute("errorMessage", errorMessageBean.getErrorMessage());
		return TagSupport.EVAL_BODY_INCLUDE;
	}

	public int doEndTag() {
		reset();
		return TagSupport.EVAL_PAGE;
	}

	public void reset() {
		this.key = null;
	}
}
