package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.MemberDAO;
import com.service.spring.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public int registerMember(MemberVO vo) throws Exception {
		return memberDao.registerMember(vo);
	}

	@Override
	public int deleteMember(String id) throws Exception {
		return memberDao.deleteMember(id);
	}

	@Override
	public int updateMember(MemberVO vo) throws Exception {
		return memberDao.updateMember(vo);
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return memberDao.getMember(id);
	}

	@Override
	public List<MemberVO> showAllMember() throws Exception {
		return memberDao.showAllMember();
	}

	@Override
	public String idExist(String id) throws Exception {
		return memberDao.idExist(id);
	}

}
