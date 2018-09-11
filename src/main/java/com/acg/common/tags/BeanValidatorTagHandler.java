package com.acg.common.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.acg.common.collection.ErrorMessageCollection;
import com.acg.common.tags.interfaces.ValidatableBean;

public class BeanValidatorTagHandler extends TagSupport {
	private String beanName;
	private String scope;

	public int doStartTag() throws JspException {
		ValidatableBean validatableBean = null;
		if (!scope.equalsIgnoreCase("REQUEST") && !scope.equalsIgnoreCase("SESSION")) {
			throw new JspException("Invalid scope :	" + scope);
		}
		if (scope.equalsIgnoreCase("REQUEST")) {
			validatableBean = (ValidatableBean) pageContext.getAttribute(beanName, PageContext.REQUEST_SCOPE);
		}
		if (scope.equalsIgnoreCase("SESSION")) {
			validatableBean = (ValidatableBean) pageContext.getAttribute(beanName, PageContext.SESSION_SCOPE);
		}
		if (scope.equalsIgnoreCase("APPLICATION")) {
			validatableBean = (ValidatableBean) pageContext.getAttribute(beanName, PageContext.SESSION_SCOPE);
		}
		ErrorMessageCollection errorMessageCollection;
		errorMessageCollection = validatableBean.validate();
		if (errorMessageCollection == null)
			return TagSupport.SKIP_BODY;
		if (errorMessageCollection.getCount() > 0) {
			pageContext.setAttribute("errorMessageCollection", errorMessageCollection, PageContext.REQUEST_SCOPE);
			return TagSupport.EVAL_BODY_INCLUDE;
		}
		return TagSupport.SKIP_BODY;
	}

	public int doEndTag() {
		reset();
		return TagSupport.EVAL_PAGE;
	}

	public void reset() {
		this.beanName = null;
		this.scope = null;
	}
}
