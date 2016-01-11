package com.rules.mvc.dao.util;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat (shape = JsonFormat.Shape.OBJECT)
public enum RuleAccessLevel {	
	GLOBAL, GROUP, APPLICATION;
}
