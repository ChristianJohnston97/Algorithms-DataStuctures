import java.util.*;
import java.lang.*;

public class Hashmap
{
	public static void main(String[] args)
	{

	}

	public void test()
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("hello", 1);
		int value = map.get("hello");

		int size = map.size();

		Set set = map.entrySet();

		Iterator i = set.iterator();

		while(i.hasNext())
		{
			Map.Entry me = (Map.Entry)i.next();
			System.out.println(me.getKey());

			// have to cast to type if needed 
			int val = (int)me.getValue();
		}
	}


	public void betterWay()
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("hello", 1);

		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for(Map.Entry<String, Integer> entry: set)
		{
			String str = entry.getKey();
			int val = entry.getValue();
		}
	}
}