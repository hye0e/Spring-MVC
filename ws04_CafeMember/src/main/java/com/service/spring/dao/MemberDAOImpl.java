package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	public static final String MP = "MemberMapper.";
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int registerMember(MemberVO vo) throws Exception {
		return sqlSession.insert(MP + "registerMember", vo);
	}

	@Override
	public int deleteMember(String id) throws Exception {
		return sqlSession.delete(MP + "deleteMember", id);
	}

	@Override
	public int updateMember(MemberVO vo) throws Exception {
		return sqlSession.update(MP + "updateMember", vo);
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return sqlSession.selectOne(MP + "getMember", id);
	}

	@Override
	public List<MemberVO> showAllMember() throws Exception {
		return sqlSession.selectList(MP + "showAllMember");
	}

	@Override
	public String idExist(String id) throws Exception {
		return sqlSession.selectOne(MP + "idExist", id);
	}

}
