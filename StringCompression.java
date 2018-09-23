import java.util.*;

public class StringCompression
{
	public static void main(String[] args)
	{		
		String tester = "aabbcccdd";
		String result = compress(tester);
		System.out.println(result);
	}	

	public static String compress(String string)
	{
		StringBuilder sb = new StringBuilder();
		char[] array = string.toCharArray();
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		for(int i=0; i<array.length; i++)
		{
			if(!map.containsKey(array[i]))
			{
				map.put(array[i], 1);
			}
			else
			{
				map.put(array[i], map.get(array[i]) + 1);
			}
		}

		Set set = map.entrySet();
		Iterator itor = set.iterator();
		while(itor.hasNext())
		{
			Map.Entry entry = (Map.Entry)itor.next();
			sb.append(entry.getKey());
			sb.append(entry.getValue());
		}

		String result = sb.toString();
		return result;
	}
}