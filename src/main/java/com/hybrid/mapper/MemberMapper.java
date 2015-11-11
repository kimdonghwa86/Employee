package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.Member;

public interface MemberMapper {
	List<Member> selectAll();
	void insert(Member m);
	void update(Member m);
	void deleye(Member m);
	
}
