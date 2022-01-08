package dev.mvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.mvc.persistence.MemberRepository;


@Service
public class ptogUserService implements UserDetailsService{
	@Autowired
	MemberRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{		
		return repo.findById(username).filter(m->m != null).map(m->new ptogSecurityUser(m)).get();
	}
}
