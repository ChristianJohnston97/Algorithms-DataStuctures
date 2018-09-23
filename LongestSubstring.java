import java.util.*;
import java.lang.*;

public class LongestSubstring
{
	public static void main(String[] args)
	{
		LongestSubstring ls = new LongestSubstring();
		int result = ls.longestSubstring(4, "chicken");
		System.out.println(result);
	}

	// Given an ineteger k and a string
	// find the length of the longest substring that contains at most 
	// k distinct characters 

	// E.g.  "abcba" and k = 2 ---> bcb = 3
	
	public int longestSubstring(int k, String string)
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLength = k;
		for(int i = 0; i < string.length(); i++)
		{
			char c = string.charAt(i);
			if(!map.containsKey(c))
			{
				map.put(c, 1);
			}
			else
			{
				map.put(c, map.get(c)+1);
			}
		
			int left = 0;

			if(map.size() > k)
			{
				maxLength = Math.max(maxLength, i-left);

				while(map.size() > k)
				{
					char fc = string.charAt(left);
					if(map.get(fc) == 1)
					{
						map.remove(fc);
					}
					else
					{
						map.put(fc, map.get(fc) - 1);	
					}
					left++;
				}
			}
		}
		maxLength = Math.max(maxLength, string.length()-left);
		return maxLength;
	}
}