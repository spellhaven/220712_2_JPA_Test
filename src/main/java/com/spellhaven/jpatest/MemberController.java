package com.spellhaven.jpatest;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usertest")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	
	// 모든 회원 리스트 조회
	@GetMapping
	public ResponseEntity<List<MemberDto>> getAllMemberList() {
		
		List<MemberDto> memberList = memberService.findAll();
		
		return new ResponseEntity<List<MemberDto>>(memberList, HttpStatus.OK);
	}
	
	
	// 특정 회원번호로 한 새끼만 조회
	@GetMapping("/{num}")
	public ResponseEntity<MemberDto> getMember(@PathVariable("num") Long num) {
		
		Optional<MemberDto> member = memberService.findById(num);
		return new ResponseEntity<MemberDto>(member.get(), HttpStatus.OK);
	}

	// 새로운 회원 입력
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ResponseEntity<MemberDto> saveMember(HttpServletRequest req, MemberDto member) {
		
		return new ResponseEntity<MemberDto>(memberService.save(member), HttpStatus.OK);
	}
	
	
	// ㅋㅐ삭
	@DeleteMapping("/{num}")
	public ResponseEntity<Void> deleteMember(@PathVariable("num") Long num) {
		
		memberService.deleteById(num);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	@PutMapping("/{num}")
	public ResponseEntity<MemberDto> updateMember(@PathVariable("num") Long num, MemberDto member) {
		memberService.updateById(num, member);
		return new ResponseEntity<MemberDto>(member, HttpStatus.OK);
	}
	
	
	
}































