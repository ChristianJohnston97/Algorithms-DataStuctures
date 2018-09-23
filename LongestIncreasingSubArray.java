import java.util.*;

public class LongestIncreasingSubArray
{
	public static void main(String[] args)
	{
		int[] testArray = {6,7,5,6,8,2};
		compute(testArray);
		String string = "heallo";
		longestSubstring(string);
	}

	// O(n)
	// Sliding window 
	public static void compute(int[] array)
	{
		int max = 1;
		int length = 1;

		for(int i = 0; i<array.length-1; i++)
		{
			if(array[i+1] > array[i])
			{
				length++;
			}
			else
			{
				if(length > max)
				{
					max = length;
				}
				length = 1;
			}
		}
		if(length > max)
		{
			max = length;
		}
		System.out.println(max);
	}

	public static void longestSubstring(String string)
	{
		HashSet<Character> set = new HashSet<Character>();
		int biggest = 0;
		int counter = 0;
		for(int i=0; i<string.length()-1; i++)
		{
			char c = string.charAt(i);
			if(!set.contains(c))
			{
				set.add(c);
				counter++;
			}
			else
			{
				if(counter > biggest)
				{
					biggest = counter;
				}
				counter = 0;
				set.clear();
			}
			if(counter > biggest)
			{
				biggest = counter;
			}
		}
		System.out.println(biggest);
	}
}