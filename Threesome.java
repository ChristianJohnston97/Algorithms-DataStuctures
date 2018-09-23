import java.util.*;

public class Threesome
{
	public static void main(String[] args)
	{
		int[] array = {3,5,7,3,1,8,9};
		int result = threesome2(array);
		System.out.println(result);
	}

	// sorted array, find three numbers with the maximum value when summed


	// brute force
	public static int threesome(int[] array)
	{
		int best = 0;

		for(int i = 0; i < array.length-2; i++)
		{
			for(int j = i+1; j < array.length-1; j++)
			{
				for(int k = j+1; k < array.length; k++)
				{
					int sum = array[i] + array[j] + array[k];
					if(sum > best)
					{
						best = sum;
					}
				}
			}
		}
		return best;
	}

}