package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.MyProduct;

@Repository
public class MyProductDAOImpl implements MyProductDAO {
	
	private static final String MAPPER = "MyProductMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addProduct(MyProduct vo) throws Exception {
		return sqlSession.insert(MAPPER + "addProduct", vo);
	}
	
	@Override
	public List<MyProduct> findProducts() throws Exception {
		return sqlSession.selectList(MAPPER + "findProducts");
	}

	@Override
	public List<MyProduct> findProductByName(String name) throws Exception {
		return sqlSession.selectList(MAPPER + "findProductByName", name);
	}

	@Override
	public List<MyProduct> findProductByMaker(String maker) throws Exception {
		return sqlSession.selectList(MAPPER + "findProductByMaker", maker);
	}



}
