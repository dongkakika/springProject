package dev.mvc.member;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.persistence.MemberRepository;

@Controller
public class MemberController {
	
	@Autowired
	MemberRepository repo;
	
	@Autowired
	PasswordEncoder pwEncoder;
	
	@GetMapping("/member/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/login");
		return modelAndView;
	}
	
	@GetMapping("/member/logout")
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/logout");
		return modelAndView;
	}
	
	@GetMapping(value="/member/register")
	public ModelAndView register() {
		System.out.println("----------가입 시작----------");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/register");
		return modelAndView;
	}
	
	@PostMapping("/member/register")
	@Transactional
	public ModelAndView loginPost(@ModelAttribute("member")Member member) {
		System.out.println("----------가입 완료----------");
		String encryptPw = pwEncoder.encode(member.getUserpw());
		
		member.setUserpw(encryptPw);
		
		repo.save(member);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/registerResult");		
		return modelAndView;
	}
	
	@GetMapping(value="/manager/manage")
	public ModelAndView manage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/manager/manage");
		return modelAndView;
	}
}
