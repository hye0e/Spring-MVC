package ws01_MyBatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import servlet.model.MemberVO;

public class MyBatisMemberTestApp {

	public static void main(String[] args) throws IOException {
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();

		// 1. registerMember
		MemberVO newMem = new MemberVO("test2", "아이유", "1234", "서울 대치동");
//		Object obj = session.insert("MemberMapper.registerMember", newMem);
//		session.commit(); //이 부분 반드시 해줘야 한다....mvc에서는 생략가능.
//		System.out.println(":: 1. registerMember(INSERT)  result ? "+obj); //1
//		System.out.println("\n");
		
		// 2. deleteMember
//		int deleteResult = session.delete("MemberMapper.deleteMember", newMem.getId());
//		session.commit(); //이 부분 반드시 해줘야 한다.
//		System.out.println(":: 2. deleteMember(DELETE) result ? "+deleteResult);
//		System.out.println("\n");
		
		// 3. "updateMember"
//		newMem.setAddress("경기도 부천");
//		Object obj = session.insert("MemberMapper.updateMember", newMem);
//		session.commit(); //이 부분 반드시 해줘야 한다....mvc에서는 생략가능.
//		System.out.println(":: 1. updateMember(UPDATE)  result ? "+obj); //1
//		System.out.println("\n");
		
		// 3. showAllMember
		List<MemberVO> list = session.selectList("MemberMapper.showAllMember");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		
		// 4. getMember
		MemberVO member = (MemberVO)session.selectOne("MemberMapper.getMember", newMem.getId());
		System.out.println(member.toString());
		
		// 5. idExist
		String id = (String)session.selectOne("MemberMapper.idExist", newMem.getId());
		System.out.println(":: 5. idExist :: " + id); //
		
		// 5. Login
		String name = (String)session.selectOne("MemberMapper.Login", newMem);
		System.out.println(":: 6. Login :: " + name); //
	}

}
