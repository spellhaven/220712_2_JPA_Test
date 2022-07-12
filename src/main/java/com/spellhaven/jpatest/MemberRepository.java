package com.spellhaven.jpatest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberDto, Long>{ // <DTO 이름, PK의 자료형>

	// 이건 꼭 인터페이스로 만들어 줘야 한다.
	// 와! 빈 인터페이스인데 이렇게나 연결을 잘 하다니. 신기하지?
	
}
