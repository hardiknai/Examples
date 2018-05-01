package com.org.model;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/databaseProperties")
@ConfigurationProperties("database")
public class DatabaseProperties {

	private boolean enable;
	
	private InetAddress remoteAddress;
	
	private final Security security = new Security();
	
	
	public boolean isEnable() {
		return enable;
	}


	public Security getSecurity() {
		return security;
	}


	public void setEnable(boolean enable) {
		this.enable = enable;
	}


	public InetAddress getRemoteAddress() {
		return remoteAddress;
	}


	public void setRemoteAddress(InetAddress remoteAddress) {
		this.remoteAddress = remoteAddress;
	}


	class Security{
		
		private String username;
		
		private String password;
		
		private List<String> roles = new ArrayList<>(Collections.singleton("USER"));
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public List<String> getRoles() {
			return roles;
		}
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
		@Override
		public String toString() {
			return "Security [username=" + username + ", password=" + password + ", roles=" + roles + "]";
		}
		
		
		
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/get")
	public String getDatabaseProperties() {
		return toString();
	}
	


	@Override
	public String toString() {
		return "DatabaseProperties [enable=" + enable + ", remoteAddress=" + remoteAddress + ", security=" + security
				+ "]";
	}
	
}
