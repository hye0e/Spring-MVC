package spring.service.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.user.MemberService;
/*
 * FileName : MyBatisTestApp13.java
  * ㅇ SqlMapConfig01.xml / mybatis-userservice-mapping10.xml
  * ㅇ userService13.xml 
  * ㅇ Annotation 기반 설정 Test
  */
public class MyBatisTestApp {
	///Main method
	public static void main(String[] args) throws Exception{

		ApplicationContext context =
			new ClassPathXmlApplicationContext(
							new String[] {	"/beans/memberservice.xml"	 }
								                                                    );
	//==> IoC Container 로 부터 획득한 UserDAO 인스턴스 획득
	MemberService memberService = (MemberService)context.getBean("memberServiceImpl");
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//2.UserService.getUser(userId) Test
	MemberVO member = memberService.getMember("test2");
	System.out.println(":: 1. getMember(SELECT)  ? "+member);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//4.UserService.getUser(userId) Test
	List<MemberVO> memberList = memberService.showAllMember();
	System.out.println(":: 2. showAllMember(SELECT)  ? ");
	for (int i =0 ;  i < memberList.size() ; i++) {
		System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
		System.out.println( memberList.get(i).toString() );
	}
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//6.UserService.getUserList() Test
	System.out.println(":: 3. idExist(SELECT)  ? ");
	String existedId = memberService.idExist("test2");
	System.out.println("existedId >> " + existedId);
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		
	}//end of main
}//end of class