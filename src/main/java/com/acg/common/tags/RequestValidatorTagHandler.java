package com.acg.common.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

public class RequestValidatorTagHandler extends TagSupport {
	public int doStartTag() {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		String source = request.getParameter("source");
		String target = request.getParameter("target");
		if (source == null || target == null || source.trim().length() == 0 || target.trim().length() == 0) {
			return TagSupport.EVAL_BODY_INCLUDE;
		}
		return TagSupport.SKIP_BODY;
	}

	public int doEndTag() {
		reset();
		return TagSupport.EVAL_PAGE;
	}

	public void reset() {
	}
}
