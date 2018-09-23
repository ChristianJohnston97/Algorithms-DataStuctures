import java.util.*;
import java.lang.*;

public class NumCommonElements
{
	public static void main(String[] args)
	{
		// distint and ordered arrays 
		int[] testArray = {2, 3, 14, 16, 18, 22};
		int[] testArray2 = {4, 14, 15, 19, 22, 24, 27};
		NumCommonElements nm = new NumCommonElements();
		//int result = nm.bruteForce(testArray, testArray2);
		int result = nm.algorithm2(testArray, testArray2);
		System.out.println(result);
	}


	// Example
	// {2, 3, 14, 16, 18, 22}
	// {4, 14, 15, 19, 22, 24, 27}
	// Num common elements = 2 

	private int counter = 0;

	// O(ab)
	public int bruteForce(int[] array, int[] array2)
	{
		int arrayLength = array.length;
		int array2Length = array2.length;

		for(int i = 0; i < arrayLength; i++)
		{
			for(int j= 0; j < array2Length; j++)
			{
				if(array[i] == array2[j])
				{
					counter ++;
				}
			}
		}
		return counter;
	}

	//O(a+b)
	public int algorithm2(int[] array, int[] array2)
	{
		int arrayLength = array.length;
		int array2Length = array2.length;

		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		for(int i = 0; i < arrayLength; i++)
		{
			int key = array[i];
			if(hs.containsKey(key) == true)
			{
				int value = hs.get(key);
				value++;
				hs.put(key, value);
			}
			else
			{
				hs.put(key, 1);
			}
		}

		for(int i = 0; i < array2Length; i++)
		{
			int key = array2[i];
			if(hs.containsKey(key) == true)
			{
				counter++;
			}
		}
		return counter;
	}

	//O(a+b)
	public int algorithm3(int[] array1, int[] array2)
	{
		int array1Length = array1.length;
		int array2Length = array2.length;
		int counter = 0;
		int i = 0;
		int j = 0;

		while(i < array1Length && j < array2Length)
		{
			if(array1[i] < array2[j])
			{
				i++;
			}
			else if(array1[i] > array2[j])
			{
				j++;
			}
			else
			{
				counter ++;
				i++;
				j++;
			}
		}
		return counter;
		
	}	

}