package dev.mvc.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import dev.mvc.member.Member;
import dev.mvc.member.MemberRole;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ptogSecurityUser extends User{
	private static final String ROLE_PREFIX = "ROLE_";
	
	private Member member;
	
	public ptogSecurityUser(Member member) {
		super(member.getUserid(), member.getUserpw(), makeGrantedAuthority(member.getRoles()));
		this.member = member;
	}
	
	private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles){
		List<GrantedAuthority> list = new ArrayList<>();
		
		roles.forEach(role->list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));
		
		return list;
	}
}