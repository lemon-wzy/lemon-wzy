package shiro.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shiro.demo.redis.cache.IGlobalCache;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	private IGlobalCache iGlobalCache;

	@Test
	public void  test() {
		iGlobalCache.set("key2","value2");
		iGlobalCache.lSetAll("list", Arrays.asList("hello","redis"));
		List<Object> list = iGlobalCache.lGet("list",0,-1);
		System.out.println(iGlobalCache.get("key2"));
	}

}
