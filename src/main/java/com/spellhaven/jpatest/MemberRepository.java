package com.spellhaven.jpatest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberDto, Long>{ // <DTO 이름, PK의 자료형>

	//public List<MemberDto> findById(String id);
}
