import cn.site.xinnetapi.manager.XinnetApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016.5.23.
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration ({"classpath:applicationContext.xml",
						"classpath:application-dubbo.xml"
})
@Rollback (false)
public class DobboTest {
	@Inject
	private XinnetApiService xinnetApiService;

	@Test
	public void test () {
		System.out.println (xinnetApiService);
	}
}
