package com.service.spring;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.MemberVO;

public class UnitTest {
	@Test
	public void unit() throws Exception {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		// 1. SqlSessionFactory -- SqlSessionFactoryBean (실체)
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
				
		// 2. SqlSession -- SqlSessionTemplate (실체)
		SqlSession session = factory.openSession();
		
		MemberVO member = new MemberVO("nanda5050", "1234", "신혜영", "경기도 부천");
		session.insert("MemberMapper.registerMember", member);
		
		List<MemberVO> memList = session.selectList("MemberMapper.showAllMember");
		for (MemberVO mem : memList) {
			System.out.println(mem);
		}
		
		System.out.println("update");
		member.setName("시내영");
		session.update("MemberMapper.showAllMember");
		for (MemberVO mem : memList) {
			System.out.println(mem);
		}
		
		memList = session.selectList("MemberMapper.showAllMember");
		for (MemberVO mem : memList) {
			System.out.println(mem);
		}
		
	}
}
