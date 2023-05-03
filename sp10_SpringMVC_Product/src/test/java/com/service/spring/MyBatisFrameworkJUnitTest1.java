package com.service.spring;

// JUnit을 사용한 단위테스트...
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.MyProduct;

import oracle.ucp.common.FailoverStats.Item;

public class MyBatisFrameworkJUnitTest1 {

	@Test
	public void unit() throws Exception {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		// 1. SqlSessionFactory -- SqlSessionFactoryBean (실체)
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		// 2. SqlSession -- SqlSessionTemplate (실체)
		SqlSession session = factory.openSession();
		
		// 3. 쿼리문 실행
		MyProduct vo = new MyProduct("공기방울세탁기", "대우", 500000);
		session.insert("MyProductMapper.addProduct", vo);
//		session.commit();
		
		List<MyProduct> list = session.selectList("MyProductMapper.findProducts");
		for (MyProduct mp : list) {
			System.out.println(mp);
		}
		System.out.println("===========MyProductMapper.findProductByName=============");
		List<MyProduct> list2 = session.selectList("MyProductMapper.findProductByName", "세탁기");
		for (MyProduct mp : list2) {
			System.out.println(mp);
		}
		
		System.out.println("\n========3. findProductByMaker ==============");
		List<MyProduct> list3 = session.selectList("MyProductMapper.findProductByMaker","대우");
		for(MyProduct prduct : list3)
			System.out.println(prduct);
	
	}

}
