package s57map.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import s57map.dao.Object2dAnd3dDao;
import s57map.service.Object2dAnd3dService;
import s57map.utils.SpringUtils;


public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Object2dAnd3dService dao = context.getBean("object2dAnd3dService", Object2dAnd3dService.class);
		dao.getLand(71);
	}
}
