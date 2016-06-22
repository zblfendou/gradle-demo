package cn.zbl.test;

/**
 * Created by Administrator on 2016.5.27.
 */
public class Test {
	/**
	 * 根据身份编号获取性别
	 * @param idCard
	 * 		身份编号
	 * @return 性别(M-男，F-女，N-未知)
	 */
	public static String getGenderByIdCard (String idCard) {
		String sGender = "N";
		String sCardNum = idCard.substring (16, 17);
		if (Integer.parseInt (sCardNum) % 2 != 0) {
			sGender = "M";
		} else {
			sGender = "F";
		}
		return sGender;
	}

	@org.junit.Test
	public void test () {
		System.out.println (getGenderByIdCard ("511702199002221492"));
	}

}
