package com.acg.common.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class FormResubmissionCheckerTagHandler extends TagSupport {
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		String formId = request.getParameter("formId");
		if (formId == null)
			return TagSupport.EVAL_BODY_INCLUDE;
		HttpSession session = request.getSession();
		if (session.getAttribute(formId) == null)
			return TagSupport.EVAL_BODY_INCLUDE;
		session.removeAttribute(formId);
		return TagSupport.SKIP_BODY;
	}

	public int doEndTag() {
		reset();
		return TagSupport.EVAL_PAGE;
	}

	public void reset() {
	}
}
