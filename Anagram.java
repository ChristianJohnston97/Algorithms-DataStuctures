import java.util.*;

public class Anagram
{
	public static void main(String[] args)
	{
		String testString = "help";
		String[] list = {"pleh", "elph", "not"};
		List<String> result = anagram(testString, list);
		for(String str: result)
		{
			System.out.println(str);
		}
	}


	public static List<String> anagram(String string, String[] list)
	{
		Set<String> set = new HashSet<String>();
		List<String> output = new ArrayList<String>();

		String signature = order(string);
		set.add(signature);


		for(String st: list)
		{
			String ordered = order(st);
			if(set.contains(ordered))
			{
				output.add(st);
			}
		}
		return output;
	}

	public static String order(String string)
	{
		char[] array = string.toCharArray();
		Arrays.sort(array);
		return new String(array);
	}
}