package com.acg.common.tags.interfaces;

import java.io.Serializable;

import com.acg.common.collection.ErrorMessageCollection;

public interface ValidatableBean extends Serializable {
	public ErrorMessageCollection validate();
}
