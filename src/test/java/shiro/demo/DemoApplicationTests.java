package shiro.demo;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shiro.demo.redis.cache.IGlobalCache;
import shiro.demo.utils.FileUploadUtil;

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
	private StringEncryptor stringEncryptor;

	@Test
	public void encrypt() {
//		String url = encryptor.encrypt("jdbc\\:mysql\\://127.0.0.1\\:3306/test?useUnicode\\=true&characterEncoding\\=UTF-8&zeroDateTimeBehavior\\=convertToNull&useSSL\\=false&allowMultiQueries\\=true&serverTimezone=Asia/Shanghai");
		String url = stringEncryptor.encrypt("jdbc:mysql://110.42.250.78:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC");
		String name = stringEncryptor.encrypt("root");
		String password = stringEncryptor.encrypt("root");
		System.out.println("database url: " + url);
		System.out.println("database name: " + name);
		System.out.println("database password: " + password);
		Assert.assertTrue(url.length() > 0);
		Assert.assertTrue(name.length() > 0);
		Assert.assertTrue(password.length() > 0);
	}






//	@Autowired
//	private IOsAreaService iOsAreaService;

//	@Test
//	public void  test() {
//		iGlobalCache.set("key2","value2");
//		iGlobalCache.lSetAll("list", Arrays.asList("hello","redis"));
//		List<Object> list = iGlobalCache.lGet("list",0,-1);
//		System.out.println(iGlobalCache.get("key2"));
//	}

//	@Test
//	public void testSQl() {
//		String name  = iOsAreaService.getOne(Wrappers.<OsArea>query().lambda().eq(OsArea::getPid,0)).getName();
//		System.out.println("this is a test controller demo:"+ name);
//	}

}
