package com.acg.common.tags;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

public class ErrorMessageTagHandlerTEI extends TagExtraInfo {
	public VariableInfo[] getVariableInfo(TagData tagData) {
		VariableInfo variableInfo[] = new VariableInfo[1];
		variableInfo[0] = new VariableInfo("errorMessage", "java.lang.String", true, VariableInfo.NESTED);
		return variableInfo;
	}
}
