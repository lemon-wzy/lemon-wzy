package shiro.demo;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shiro.demo.modules.area.entity.OsArea;
import shiro.demo.modules.area.service.IOsAreaService;
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

	@Autowired
	private IOsAreaService iOsAreaService;

	@Test
	public void  test() {
		iGlobalCache.set("key2","value2");
		iGlobalCache.lSetAll("list", Arrays.asList("hello","redis"));
		List<Object> list = iGlobalCache.lGet("list",0,-1);
		System.out.println(iGlobalCache.get("key2"));
	}

	@Test
	public void testSQl() {
		String name  = iOsAreaService.getOne(Wrappers.<OsArea>query().lambda().eq(OsArea::getPid,0)).getName();
		System.out.println("this is a test controller demo:"+ name);
	}

}
