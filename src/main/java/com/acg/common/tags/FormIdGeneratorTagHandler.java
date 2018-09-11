package com.acg.common.tags;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class FormIdGeneratorTagHandler extends TagSupport {
	private String source;
	private String target;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public int doStartTag() throws JspException {
		if (target.trim().length() == 0) {
			throw new JspException("Target attribute missing in request");
		}
		String formId = UUID.randomUUID().toString();
		pageContext.setAttribute(formId, formId, pageContext.SESSION_SCOPE);
		JspWriter jw = pageContext.getOut();
		if (source == null || source.trim().length() == 0) {
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			String y = request.getRequestURI().toString();
			source = y.substring(1).substring(y.substring(1).indexOf("/"));
		}
		try {
			jw.write("<input type='hidden' name='formId' id='formId' value='" + formId + "'>");
			jw.write("<input type='hidden' name='source' id='source' value='" + source + "'>");
			jw.write("<input type='hidden' name='target' id='target' value='" + target + "'>");
		} catch (IOException ioException) {
		}
		return super.EVAL_BODY_INCLUDE;
	}

	public int doEndTag() {
		reset();
		return super.EVAL_PAGE;
	}

	public void reset() {
		this.source = null;
		this.target = null;
	}
}
