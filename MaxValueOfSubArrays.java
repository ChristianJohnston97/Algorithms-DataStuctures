import java.util.*;

public class MaxValueOfSubArrays
{
	public static void main(String[] args)
	{
		int[] testString = {3,4,6,8,3,1,2};
		int[] result = compute(testString, 3);
		System.out.println(Arrays.toString(result));
	}

	public static int[] compute(int[] array, int k)
	{
		int arrayLength = array.length;
		int[] result = new int[arrayLength-k+1];
		int j;
		int max;
		for(int i=0; i <= arrayLength-k; i++)
		{
			max = array[i];
			for(j=1; j<k; j++)
			{
				if(array[i+j] > max)
				{
					max = array[i+j];
				}
			}
			result[i] = max;
		}
		return result;
	}
}