package com.org.config;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class BasePermissionEvaluator implements PermissionEvaluator{

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		if(authentication != null && targetDomainObject instanceof String) {
			if("hasAccess".equalsIgnoreCase(""+targetDomainObject)) {
				return validateAccess("" +permission);
			}
		}
			
		return false;
	}

	public boolean validateAccess(String permission) {
		if("READ".equalsIgnoreCase(permission))
			return true;
		return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		return false;
	}

}
