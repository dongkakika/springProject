package dev.mvc.persistence;

import org.springframework.data.repository.CrudRepository;

import dev.mvc.member.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
	
}
