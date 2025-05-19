package com.sist.web.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.*;
import com.sist.web.vo.*;
// JPA방식 => 1.return 형, 2. 매개변수 , 3. 메서드명 => 자동지정
// 필요시에 의하면 메서드 규칙에 따라 제작
// WHERE 문장 => findBy변수명명령어 where name like => less then, greater then
// SQL 문장이 필요시에는 반드시 native query

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public void saveMember(Member member)
	{
		memberRepository.save(member);
	}
	
	public void deleteMember(Member member)
	{
		memberRepository.delete(member);
	}
	
	public Iterable<Member> getAllMembers()
	{
		return memberRepository.findAll();
	}
	
	public Member getMemberId(String id)
	{
		return memberRepository.findById(id).orElse(null);
	}
}
