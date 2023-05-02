package sp05_AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.solve.MemberService;
import spring.aop.solve.ProductService;

public class AopAppTest2 {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("beans/solve.xml");
		
		System.out.println("prob.csm을 불러 빈을 생성");
		
		MemberService member = (MemberService)factory.getBean("member");
		ProductService product = (ProductService)factory.getBean("product");
		member.register("kbstar");
		member.findMember("kbstar");
		
		System.out.println("=========================");
		product.deleteProduct("aaa");
	}

}
