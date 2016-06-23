import cn.spring.rest.client.test.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.http.*;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016.5.30.
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration ({"classpath:application-context.xml",
		"classpath:application-restful.xml"})
@Rollback (false)
public class Test {
	@Inject
	private RestTemplate restTemplate;

	@org.junit.Test
	public void test () {
		try {

			ResultVo vo = new ResultVo ();
			vo.setFlowUUID ("77777777777");
			vo.setCode ("0");
			vo.setRefSiteCode ("XINNET1606232913");
			vo.setWebsiteCode ("XINNETaaaaaabbbb");
			vo.setMakeDomainResult ("asdfasdfasdf");
			vo.setProductDomainResult ("aaaaaaaaaaaaaaaaaaaa");
			ObjectMapper mapper = new ObjectMapper ();
			String requestJson = mapper.writeValueAsString (vo);
			HttpHeaders headers = new HttpHeaders ();
			headers.setContentType (MediaType.APPLICATION_JSON);

			HttpEntity<String> entity = new HttpEntity<String> (requestJson, headers);
			restTemplate.postForEntity ("http://172.23.201.44:8089/jz/notifyCreateFinish.do", entity, Void.class);

		} catch (Exception e) {
			e.printStackTrace ();
		}
	}

	@org.junit.Test
	public void testvo () {
		try {
			String flowVoEntity = restTemplate.postForObject ("http://172.23.201.44:8889/rest1/q/a", null, String.class);
			System.out.println (flowVoEntity);
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}

	@org.junit.Test
	public void testvoStr () {
		try {
			RestResultVo vo = new RestResultVo ();
			vo.setFlowUUID ("aaa");
			restTemplate.postForObject ("http://172.23.201.44:8089/jz/notifyCreateFinish", vo, Object.class);
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}

	@org.junit.Test
	public void testCode () {
		String code = "1201605273888";
		String generator = "JZ" + code.substring (2, code.length ());
		System.out.println (generator);
	}
}
