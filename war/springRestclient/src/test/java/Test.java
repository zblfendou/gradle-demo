import cn.spring.rest.client.test.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.MapUtils;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.*;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.*;

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
			FlowVo flowVo = new FlowVo ();
			flowVo.setFlowUUID ("77777777777");
			String voJson = null;
			try {
				voJson = new ObjectMapper ().writeValueAsString (flowVo);
			} catch (JsonProcessingException ignore) {
				ignore.printStackTrace ();
			}
			Map<String, Object> map = new HashMap<> ();
			map.put ("voJson", voJson);
			MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<> ();
			map.keySet ().stream ().forEach (key -> requestEntity.add (key, MapUtils.getObject (map, key, "")));
			String url = "http://172.23.201.44:8887/rest/q/a";
			FlowVo flowVoObject = restTemplate.postForObject (url, requestEntity, FlowVo.class);
			FlowVo flowVoEntity = restTemplate.postForEntity (url, requestEntity, FlowVo.class).getBody ();
			System.out.println (flowVoEntity.getDesignerName ());
			System.out.println (flowVoObject.getFlowUUID () + "   " + flowVoObject.getLanguage () + "   " + flowVoObject.getDesignerName ());
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
