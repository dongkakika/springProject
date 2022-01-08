package dev.mvc;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import dev.mvc.member.Member;
import dev.mvc.member.MemberRole;
import dev.mvc.persistence.MemberRepository;

@SpringBootTest
@Commit
public class MemberTest {
	@Test
	public void muyaho() {
		System.out.println("----------테스트 시작 무야호----------");
	}
	
	@Autowired
	private MemberRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void testInsert() {
		for(int i=0; i<3; ++i) {
			Member member = new Member();
			MemberRole memberRole = new MemberRole();
			
			member.setUserid("tuser" + i);
			member.setUsername("tuser" + i);
			member.setUserpw(passwordEncoder.encode("1234"));
			
			if(i == 0) {
				memberRole.setRoleName("ADMIN");
			}else if(i == 1) {
				memberRole.setRoleName("MANAGER");
			}else {
				memberRole.setRoleName("ADMIN");
			}
			
			member.setRoles(Arrays.asList(memberRole));
			repo.save(member);
		}
	}
}
