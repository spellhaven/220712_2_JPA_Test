package com.spellhaven.jpatest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "jpa_member") // DB테이블 이름을 입력
public class MemberDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 이건 DB에 뭘 맡긴다는 건데... "기억안난다, ㅋ" (괜찮아)
	Long num;
	String id;
	String name;
	
	public MemberDto() {
		super();
	}

	public MemberDto(Long num, String id, String name) {
		super();
		this.num = num;
		this.id = id;
		this.name = name;
	}
	
	// @Data나 @Getter, @Setter로도 안 되는 에러 때문에 JPA를 쓰면서도 게터세터를 수작업으로 만들어야 했다;; 😩
	// (누가 보면 내가 source -> generate getters and setters 안 하고 전부 하나하나 친 줄 알겠네, ㅋ)
	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
