import com.springjms.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.jms.Destination;

/**
 * Created by Administrator on 2016.4.20.
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration ("/applicationContext.xml")
public class ProducerConsumerTest {
	@Inject
	private ProducerService producerService;
	@Inject
	@Qualifier ("adapterQueue")
	private Destination destination;


	@Test
	public void testSendMessage() {
			producerService.sendMessage(destination, "测试MessageListenerAdapter");
	}

}
