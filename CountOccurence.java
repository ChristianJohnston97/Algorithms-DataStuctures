import java.util.*;
import java.lang.*;

public class CountOccurence
{
	public static void main(String[] agrs)
	{	
		CountOccurence co = new CountOccurence();
		String testString = "hello this is a test string to test the number of occurence of each words in a string which i am doing a test on";
		Map<String, Integer> map = co.createHashMap(testString);
		int biggest = co.greatestOccurence(map);
		System.out.println(biggest);
	}

	public Map<String, Integer> createHashMap(String inputSentence)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] words = inputSentence.split(" ");
		for(String word: words)
		{
			if(!map.containsKey(word))
			{
				map.put(word, 1);
			}
			else
			{
				map.put(word, (map.get(word))+1);
			}
		}
		return map;
	}

	public int greatestOccurence(Map<String, Integer> map)
	{
		int greatest = 0;
		for(String key: map.keySet())
		{
			int value = map.get(key);
			if(value > greatest)
			{
				greatest = value;
			}
		}
		return greatest;
	}
	
}