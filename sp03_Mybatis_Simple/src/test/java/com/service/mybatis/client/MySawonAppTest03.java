package com.service.mybatis.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

import util.FactoryService;

public class MySawonAppTest03 {

	public static void main(String[] args) throws Exception {
		SqlSessionFactory factory = FactoryService.getFactory();
		
		// 3. SqlSession 생성
		SqlSession session = factory.openSession();
		System.out.println("SqlSession Creating.....");
		/**
		 * SqlSession에는 쿼리문을 실행하는 함수가 다 들어있다.
		 * 
		 * int insert()
		 * int delete()
		 * int update()
		 * Object selectOne()
		 * List selectList()
		 */
		List<MySawon> sawonList = session.selectList("sawonMapper.sawonList");
		for (MySawon sawon: sawonList) {
			System.out.println(sawon);
		}
		
	}

}
