package com.bns.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ApplicationUserDetails implements UserDetails {

	
	private String userName;
	private String password;
	private String roles;
	private boolean active;
	private String infEntryId;
	
	public ApplicationUserDetails(UserAuthDetail user){
		this.password = user.getPassword();
		this.userName = user.getUserName();
		this.roles = user.getRoles();
		this.active =user.isActive();
		this.infEntryId = user.getInfEntryId();
	}
	
	public ApplicationUserDetails(){
		
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority(roles));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return active;
	}

	public String getInfEntryId() {
		return infEntryId;
	}

	public void setInfEntryId(String infEntryId) {
		this.infEntryId = infEntryId;
	}
	
}
