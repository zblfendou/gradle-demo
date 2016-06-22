import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

/**
 * Created by Administrator on 2016.5.4.
 */
public class TestJava8 {
	@org.junit.Test
	public void test () {
		List<String> list = new ArrayList<String> ();
		list.add ("TaoBao");
		list.add ("ZhiFuBao");
		List<String> listLowerNames = new ArrayList<String> ();
		for (String name : list) {
			listLowerNames.add (name);
		}
	}

	@org.junit.Test
	public void testlambda () {
		List<String> names = new ArrayList<> ();
		names.add ("TaoBao");
		names.add ("ZhiFuBao");
		List<String> listLowerNames = names.stream ().map (name -> name.toLowerCase ()).collect (Collectors.toList ());

	}

	@org.junit.Test
	public void testJoinedDot () {
		List<String> list = new ArrayList<> ();
		list.add ("a");
		list.add ("b");
		list.add ("c");
		list.add ("d");
		String joinedDotStr = list.stream ().map (Object:: toString).collect (Collectors.joining (","));
		System.out.println (joinedDotStr);
	}

	@org.junit.Test
	public void testListToSet () {
		List<String> names = new ArrayList<> ();
		names.add ("TaoBao");
		names.add ("ZhiFuBao");
		names.add ("JD");
		names.add ("L");
		TreeSet<String> set = names.stream ().map (name -> name).collect (Collectors.toCollection (TreeSet::new));
		set.stream ().forEach (System.out:: println);
	}

	@org.junit.Test
	public void testSumInt () {
		List<Integer> list = new ArrayList<Integer> ();
		list.add (2);
		list.add (1);
		list.add (3);
		list.add (4);
		list.add (5);
		Integer sum = list.stream ().collect (Collectors.summingInt (value -> value));
		System.out.println (sum);
	}

	@org.junit.Test
	public void testMapping () {
		City shanghai = new City ("shanghai");
		City beijing = new City ("beijing");
		People people1 = new People ("zhangsan", "san", shanghai);
		People people3 = new People ("wangwu", "wu", shanghai);
		People people2 = new People ("lisi", "si", beijing);
		List<People> peoples = new ArrayList<> ();
		peoples.add (people1);
		peoples.add (people2);
		peoples.add (people3);
		Map<City, Set<String>> map = peoples.stream ().collect (groupingBy (People:: getCity, mapping (People:: getLastName, toSet ())));
		Map<String, String> nameAndAddress = peoples.stream ().collect (Collectors.toConcurrentMap (People:: getName, People:: getLastName, (s, a) -> s + "," + a, ConcurrentHashMap::new));
		String shanghai1 = nameAndAddress.get ("lisi");
		System.out.println (shanghai1);

	}

	@Test
	public void testMethods () {
		Object[] nums = new Object[] {1,3, 1, 2,null,null, 3, 4, 5, 6, 7,7, 8, 9, 9,10,11};
		System.out.println ("sum is:" + Arrays.stream (nums).filter (num -> num != null).
				distinct ().mapToInt (num -> (Integer) num * 2).
				peek (System.out:: println).skip (2).limit (4).sum ());

	}

	@Test
	public void testGenerateNum () {
		Stream.generate(Math::random).limit(5).forEach(System.out::println);
	}

}
