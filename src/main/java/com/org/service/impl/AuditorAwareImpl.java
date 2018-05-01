package com.org.service.impl;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import com.org.model.User;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getFirstName();
	}

}
