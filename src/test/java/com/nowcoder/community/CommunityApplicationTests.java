package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MySpringBootApplication.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//集成了JUnit5 上面这个可以不用加
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Autowired
	@Qualifier("alphaDaoImplMybatis")
	private AlphaDao alphaDao;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	@Test
	void contextLoads() {
		System.out.println(applicationContext);
//		AlphaDao alphaDaoImpl = applicationContext.getBean(AlphaDao.class);
//		System.out.println(alphaDaoImpl);
//		alphaDaoImpl.select();
//		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println("当时时间");
		System.out.println(simpleDateFormat.format(new Date()));

		alphaDao.select();

	}
}
