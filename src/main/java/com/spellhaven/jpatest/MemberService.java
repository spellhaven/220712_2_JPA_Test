package com.spellhaven.jpatest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	
	// 이게 MyBatis.mapper와 SQL문을 대신한다고 생각하면 된다. MemberController와 하나씩 연결된다.
	// 개웃겨... 그냥 SQL문인데 자바 문법이라는 포장지로 싼 것 뿐이잖아요. 그런데도 개발자들이 와! SQL 않보인다! ^^ 이렇게 좋아하네.
	
	
	@Autowired
	private MemberRepository memberRepository;
	
	public List<MemberDto> findAll() { // 모든 리스트 출력해 주는 메서드 (SELECT)
		
		List<MemberDto> members = new ArrayList<>();
		memberRepository.findAll().forEach(e -> members.add(e));
		
		return members;
	}
	
	
	public Optional<MemberDto> findById(Long urKidneys) { // 특정 아이디(Long urKidneys)로 조회하는 함수. (SELECT)
		
		// Optional 자료구조는 null 포인터 에러를 막아 주는 놈이다. 그냥 뭐... JPA 만드는 놈들이 findById 함수를 Optional 자료형 쓰게 만들었으니, 우린 그거에 맞춰 줄 뿐이다.
		Optional<MemberDto> member = memberRepository.findById(urKidneys);
		
		return member;
	}
	
	
	public void deleteById(Long myKidneys) { // 특정 아이디(Long myKidneys)로 조회하여 삭제. 인싸들은 인수 이름 Long num이라고 안 하고 long myKidneys라고 함, ㅋ
		
		memberRepository.deleteById(myKidneys);
		
	}
	
	public MemberDto save(MemberDto member) { // 새로운 멤버 데이터 삽입 (INSERT)
		memberRepository.save(member);
		
		return member;
	}
	
	
	// JPA는 사람 ㅈㄴ 귀찮게 하는데, update라는 함수가 없기 때문이다. findById 해서 가져와 -> 고쳐서 -> 저장. 이래야 한다. 팍 씨, 귀찮아 죽겠네.
	public void updateById(Long num, MemberDto member) { // 왜 인수가 이 두 개인지 알지? search by id -> update member data
		
		// 해당 아이디 멤의 기존 데이터(dto)
		Optional<MemberDto> member_temp = memberRepository.findById(num);
		
		// 수정한 내용으로 업데이트
		if(member_temp.isPresent()) {
			member_temp.get().setNum(member.getNum());
			member_temp.get().setId(member.getId());
			member_temp.get().setName(member.getName());
			
			// 수정 - 업뎃한 내용을 저장
			memberRepository.save(member);
		}
		
		
		
	}
	
	

}































