package cn.spring.rmi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.*;

/**
 * Created by Administrator on 2016.5.26.
 */
@RestController
public class TestController {
	@RequestMapping (value = "/rest/{name}/{value}")
	public FlowVo testRest (@PathVariable String name,
	                        @PathVariable String value,
	                        @RequestParam ("voJson") String voJson) throws UnsupportedEncodingException {
		System.out.println (name + "   " + value + "    voJson:" + voJson);
		ObjectMapper mapper = new ObjectMapper ();
		FlowVo flowVo = null;
		try {
			flowVo = mapper.readValue (voJson, FlowVo.class);
			System.out.println ("chengle " + flowVo.getFlowUUID ());
		} catch (IOException e) {
			e.printStackTrace ();
		}
		flowVo.setDesignerName ("zbl");
		flowVo.setLanguage ("zh-cn");
		return flowVo;
	}

	@RequestMapping (value = "/rest1/{name}/{value}")
	public FlowVo testRest1 (@PathVariable String name,
	                         @PathVariable String value,
	                         @RequestBody String vo) throws IOException {
		System.out.println (name + "   " + value + "    voJson:" + vo);
		ObjectMapper mapper = new ObjectMapper ();
		FlowVo flowVo = mapper.readValue (vo, FlowVo.class);

		flowVo.setDesignerName ("zbl123");
		flowVo.setLanguage ("zh-cn");
		return flowVo;
	}

	@RequestMapping (value = "/rest2/{name}/{value}")
	public String testRest2 (@PathVariable String name,
	                         @PathVariable String value,
	                         @RequestBody String vo) throws IOException {
		System.out.println (name + "   " + value + "    voJson:" + vo);
		ObjectMapper mapper = new ObjectMapper ();
		FlowVo flowVo = mapper.readValue (vo, FlowVo.class);

		flowVo.setDesignerName ("zbl4444");
		flowVo.setLanguage ("zh-cn");
		return mapper.writeValueAsString (flowVo);
	}
}
