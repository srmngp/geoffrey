package es.alfatecsistemas.glpinfo.geoffrey.support;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("security")
@Scope("session")
public class SecuritySupport {
	
	private UserDetails userDetails;
	
	@PostConstruct
	public void init() {
		userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	public String getLogin() {		
		return userDetails.getUsername();
	}
	
	public boolean hasRole(String role) {
		for (GrantedAuthority grantedAutority : userDetails.getAuthorities()) {
			if (grantedAutority.getAuthority().equals(role)) {
				return true;
			}
		}
		return false;
	}
}
