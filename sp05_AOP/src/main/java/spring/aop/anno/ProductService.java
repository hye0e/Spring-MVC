package spring.aop.anno;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductService {
	public String deleteProduct(String id) {
		System.out.println(id + " .. . . deleteProduct . . . .삭제 성공");
		return "삭제된 상품ID: " + id;
	}
}
