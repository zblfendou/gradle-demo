import java.util.*;

/**
 * Created by Administrator on 2016.4.20.
 */
public class TestMain {
	private String url = "http://172.23.201.36:8080/";
	private String charset = "utf-8";
	private HttpClientUtil httpClientUtil = null;

	public TestMain(){
		httpClientUtil = new HttpClientUtil();
	}

	public void test(){
		String httpOrgCreateTest = url + "httpOrg/create";
		Map<String,String> createMap = new HashMap<String,String> ();
		createMap.put("username","zhaobaogang@xinnet.com");
		createMap.put("password","test1234");
		String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);
		System.out.println("result:"+httpOrgCreateTestRtn);
	}

	public static void main(String[] args){
		TestMain main = new TestMain();
		main.test();
	}
}
